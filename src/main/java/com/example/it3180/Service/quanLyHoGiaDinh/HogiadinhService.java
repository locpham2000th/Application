package com.example.it3180.Service.quanLyHoGiaDinh;

import com.example.it3180.Converter.quanLyHoGiaDInh.HogiadinhConverter;
import com.example.it3180.DTO.quanLyHoGiaDinh.HogiadinhDTO;
import com.example.it3180.Entity.HogiadinhEntity;
import com.example.it3180.Repository.HogiadinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HogiadinhService implements IHogiadinhServer {

    private final HogiadinhConverter hogiadinhConverter;
    private final HogiadinhRepository hogiadinhRepository;

    public HogiadinhService(HogiadinhConverter hogiadinhConverter, HogiadinhRepository hogiadinhRepository) {
        this.hogiadinhConverter = hogiadinhConverter;
        this.hogiadinhRepository = hogiadinhRepository;
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

}
