package com.example.it3180.Service.quanLyHoGiaDinh;

import com.example.it3180.Converter.quanLyHoGiaDInh.HogiadinhConverter;
import com.example.it3180.DTO.quanLyHoGiaDinh.HogiadinhDTO;
import com.example.it3180.Entity.HogiadinhEntity;
import com.example.it3180.Repository.HogiadinhRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Service
public class HogiadinhService implements IHogiadinhServer {

    private final HogiadinhConverter hogiadinhConverter;
    private final HogiadinhRepository hogiadinhRepository;
    private final EntityManager em;

    public HogiadinhService(HogiadinhConverter hogiadinhConverter, HogiadinhRepository hogiadinhRepository, EntityManager em) {
        this.hogiadinhConverter = hogiadinhConverter;
        this.hogiadinhRepository = hogiadinhRepository;
        this.em = em;
    }

    public List<HogiadinhDTO> findByAll(String id, String hotenchuho, Integer sonhankhau, String diachi, Integer trangthai){
        TypedQuery<HogiadinhEntity> query = null;
        String sql = "SELECT h FROM HogiadinhEntity h WHERE h.HoTenChuHo like :hotenchuho and h.Diachi like :diachi and h.id like :id";
            if (sonhankhau == null && trangthai == null) {
                 query = em.createQuery(sql, HogiadinhEntity.class);
            }else if(sonhankhau != null && trangthai == null){
                query = em.createQuery(sql + " and h.SoNhanKhau = :SoNhanKhau", HogiadinhEntity.class);
            }else if (sonhankhau != null && trangthai != null){
                query = em.createQuery(sql + " and h.SoNhanKhau = :SoNhanKhau and h.TrangThai = :TrangThai", HogiadinhEntity.class);
            }else if (sonhankhau == null && trangthai != null){
                query = em.createQuery(sql + " and h.TrangThai = :TrangThai", HogiadinhEntity.class);
            }
            query.setParameter("hotenchuho", "%" + hotenchuho + "%")
                    .setParameter("diachi", "%" + diachi + "%")
                    .setParameter("id", "%" + id + "%");
            if (sonhankhau == null && trangthai == null){

            }else if(sonhankhau != null && trangthai == null){
                query.setParameter("SoNhanKhau", sonhankhau);
            }else if(sonhankhau != null && trangthai != null){
                query.setParameter("SoNhanKhau", sonhankhau)
                        .setParameter("TrangThai", trangthai );
            }else if(sonhankhau == null && trangthai != null){
                query.setParameter("TrangThai", trangthai );
            }
            List<HogiadinhEntity> hogiadinhEntities = query.getResultList();
            List<HogiadinhDTO> hogiadinhDTOS = new ArrayList<>();
            for (int i = 0; i < hogiadinhEntities.size(); i++) {
                hogiadinhDTOS.add(hogiadinhConverter.toDTO(hogiadinhEntities.get(i)));
            }
            return hogiadinhDTOS;

    }

    @Override
    public String addhogiadinh(String id, String hotenchuho, int sonhankhau, String diachi,int trangthai) {
        HogiadinhEntity hogiadinhEntity = new HogiadinhEntity();
        if(hogiadinhRepository.findById(id).isPresent()){
            HogiadinhDTO hogiadinhDTO = new HogiadinhDTO();
            return "error";
        }else{
            hogiadinhEntity.setId(id);
            hogiadinhEntity.setHoTenChuHo(hotenchuho);
            hogiadinhEntity.setSoNhanKhau(sonhankhau);
            hogiadinhEntity.setDiachi(diachi);
            hogiadinhEntity.setTrangThai(0);
            hogiadinhEntity = hogiadinhRepository.save(hogiadinhEntity);
            return "Done";
        }
    }

    @Override
    public HogiadinhDTO edithogiadinh(String id, String hotenchuho, int sonhankhau, String diachi, int trangthai) {
        HogiadinhEntity oldhogiadinhEntity = hogiadinhRepository.getOne(id);
        oldhogiadinhEntity.setHoTenChuHo(hotenchuho);
        oldhogiadinhEntity.setSoNhanKhau(sonhankhau);
        oldhogiadinhEntity.setDiachi(diachi);
        oldhogiadinhEntity.setTrangThai(trangthai);
        oldhogiadinhEntity = hogiadinhRepository.save(oldhogiadinhEntity);
        return hogiadinhConverter.toDTO(oldhogiadinhEntity);
    }

    @Override
    public String deletehogiadinh(String id) {
        if(hogiadinhRepository.findById(id).isPresent()) {
            HogiadinhEntity hogiadinhEntity = hogiadinhRepository.getOne(id);
            hogiadinhRepository.delete(hogiadinhEntity);
            return "Done";
        }else{
            return "sorry";
        }
    }

    @Override
    public List<HogiadinhDTO> showhogiadinhByname(String hotenchuho) {
        List<HogiadinhEntity> hogiadinhEntities = new ArrayList<>();
        hogiadinhEntities = hogiadinhRepository.findhogiadinhByname(hotenchuho);
        List<HogiadinhDTO> hogiadinhDTOS = new ArrayList<>();
        for (int i = 0; i < hogiadinhEntities.size(); i++){
            hogiadinhDTOS.add(hogiadinhConverter.toDTO(hogiadinhEntities.get(i)));
        }
        return hogiadinhDTOS;
    }

    @Override
    public List<HogiadinhDTO> showHogiadinhByDiachi(String diachi) {
        List<HogiadinhEntity> hogiadinhEntities = new ArrayList<>();
        hogiadinhEntities = hogiadinhRepository.findAllByDiachiContaining(diachi);
        List<HogiadinhDTO> hogiadinhDTOS = new ArrayList<>();
        for (int i = 0; i < hogiadinhEntities.size(); i++){
            hogiadinhDTOS.add(hogiadinhConverter.toDTO(hogiadinhEntities.get(i)));
        }
        return hogiadinhDTOS;
    }

    @Override
    public HogiadinhDTO showin4(String id) {
        HogiadinhEntity hogiadinhEntity = new HogiadinhEntity();
        hogiadinhEntity = hogiadinhRepository.getById(id);
        HogiadinhDTO hogiadinhDTO = hogiadinhConverter.toDTO(hogiadinhEntity);
        return hogiadinhDTO;
    }

    @Override
    public Long countpaidfee(String id) {
        Long Done = hogiadinhRepository.countpaidfee(id);
        return Done;
    }

    @Override
    public Long counttotal(String id) {
        return hogiadinhRepository.countTotal(id);
    }


}
