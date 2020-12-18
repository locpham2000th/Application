package com.example.it3180.Service.quanLyDongGop;

import com.example.it3180.Converter.quanLyDongGop.DonggopConverter;
import com.example.it3180.DTO.quanLyDongGop.DonggopDTO;
import com.example.it3180.Entity.DonggopEntity;
import com.example.it3180.Entity.UnghoEntity;
import com.example.it3180.Repository.DonggopRepository;
import com.example.it3180.Repository.UnghoRepository;
import com.example.it3180.Service.quanLyDongGop.IDonggopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public DonggopDTO search(String id, String name) {
        DonggopEntity d1 = donggopRepository.getById(id);
        DonggopEntity d2 = donggopRepository.getByTenDongGop(name);
        if(d1 == null && d2 == null){
            return null;
        }
        if(d1 == d2){
            return donggopConverter.toDTO(d1);
        }else {
            return null;
        }

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
