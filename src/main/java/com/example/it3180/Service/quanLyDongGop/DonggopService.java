package com.example.it3180.Service.quanLyDongGop;

import com.example.it3180.Converter.quanLyDongGop.DonggopConverter;
import com.example.it3180.DTO.quanLyDongGop.DonggopDTO;
import com.example.it3180.Entity.DonggopEntity;
import com.example.it3180.Entity.UnghoEntity;
import com.example.it3180.Repository.DonggopRepository;
import com.example.it3180.Repository.UnghoRepository;
import com.example.it3180.Service.quanLyDongGop.IDonggopService;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Service
public class DonggopService implements IDonggopService {

    @Autowired
    private DonggopRepository donggopRepository;

    @Autowired
    private DonggopConverter donggopConverter;

    @Autowired
    private UnghoRepository unghoRepository;

    @Override
    public List<DonggopDTO>  search(String id, String name) {
        if(id == null && name == null){
            return null;
        }
        List<DonggopDTO> DTO = new ArrayList<>();
        if(id == null){
            List<DonggopEntity> d = donggopRepository.getByTenDongGop(name);
            for (DonggopEntity donggopEntity : d) {
                DTO.add(donggopConverter.toDTO(donggopEntity));
            }

        }if(name == null){
            List<DonggopEntity> d = donggopRepository.getByIdDongGop(id);
            for (DonggopEntity donggopEntity : d) {
                DTO.add(donggopConverter.toDTO(donggopEntity));
            }
        }else{
            List<DonggopEntity> d1 = donggopRepository.getByTenDongGop(name);
            List<DonggopEntity> d2 = donggopRepository.getByIdDongGop(id);
            int max = Math.max(d1.size(), d2.size());
            for(int i = 0; i < max; i++) {
                if (d1.get(i) == d2.get(i)) {
                    DTO.add(donggopConverter.toDTO(d1.get(i)));
                }
            }
        }
        if(DTO.size() == 0) return  null;
        else return DTO;

    }

    @Override
    public DonggopDTO addDongGop(String id, String tenDongGop, String mucDich) {
        DonggopEntity d = new DonggopEntity();
        d.setId(id);
        d.setMucdich(mucDich);
        d.setTenDongGop(tenDongGop);
        donggopRepository.save(d);
        return donggopConverter.toDTO(d);
    }

    @Override
    public Long countHoGiaDinh(String id) {
        return unghoRepository.countHoGiaDinh(id);
    }

    @Override
    public Long sumMoney(String id) {

        return unghoRepository.sumMoney(id);
    }

    @Override
    public void update(String id, String tenDongGop, String mucDich) {
        DonggopEntity d = donggopRepository.getById(id);
        d.setTenDongGop(tenDongGop);
        d.setMucdich(mucDich);
        donggopRepository.save(d);

    }




}
