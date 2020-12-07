package com.example.it3180.Service.quanLyDongGop;

import com.example.it3180.Converter.quanLyDongGop.DonggopConverter;
import com.example.it3180.DTO.quanLyDongGop.DonggopDTO;
import com.example.it3180.Entity.DonggopEntity;
import com.example.it3180.Entity.UnghoEntity;
import com.example.it3180.Repository.DonggopRepository;
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

    @Override
    public DonggopDTO search(Long id) {
        DonggopEntity d = donggopRepository.getById(id);
        return donggopConverter.toDTO(d);

    }

    @Override
    public DonggopDTO addDongGop(String tenDongGop, String mucDich) {
        DonggopEntity d = new DonggopEntity();
        d.setMucdich(mucDich);
        d.setTenDongGop(tenDongGop);
        donggopRepository.save(d);
        return donggopConverter.toDTO(d);
    }

    @Override
    public int sumEntity() {
        List<DonggopEntity> d = donggopRepository.findAll();
        return d.size();
    }

    @Override
    public int sumMoney() {
        List<DonggopEntity> d = donggopRepository.findAll();
        int sum = 0;
        for(DonggopEntity s : d){
            for(UnghoEntity u : s.getUngho()){
                sum = sum + u.getSotien();
            }
        }
        return sum;
    }

    @Override
    public void update(Long id, String tenDongGop, String mucDich) {
        DonggopEntity d = donggopRepository.getById(id);
        d.setTenDongGop(tenDongGop);
        d.setMucdich(mucDich);
        donggopRepository.save(d);

    }




}
