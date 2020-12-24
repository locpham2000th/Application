package com.example.it3180.Service.quanLyDongGop;

import com.example.it3180.Converter.quanLyDongGop.DonggopConverter;
import com.example.it3180.Converter.quanLyDongGop.UnghoConverter;
import com.example.it3180.DTO.quanLyDongGop.DonggopDTO;
import com.example.it3180.DTO.quanLyDongGop.UnghoDTO;
import com.example.it3180.Entity.DonggopEntity;
import com.example.it3180.Entity.HogiadinhEntity;
import com.example.it3180.Entity.UnghoEntity;
import com.example.it3180.Repository.DonggopRepository;
import com.example.it3180.Repository.HogiadinhRepository;
import com.example.it3180.Repository.UnghoRepository;
import com.example.it3180.Service.quanLyDongGop.IUnghoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class UnghoService implements IUnghoService {

    @Autowired
    UnghoRepository unghoRepository;
    @Autowired
    HogiadinhRepository hogiadinhRepository;
    @Autowired
    DonggopRepository donggopRepository;
    @Autowired
    DonggopConverter donggopConverter;
    @Autowired
    UnghoConverter unghoConverter;

    @Override
    public void addUngHo(int soTien,  String idDongGop, String idHoGiaDinh) {
        DonggopEntity d = donggopRepository.getOne(idDongGop);
        HogiadinhEntity h = hogiadinhRepository.getOne(idHoGiaDinh);
        UnghoEntity u = new UnghoEntity();
        u.setSotien(soTien);
        u.setDonggop(d);
        u.setHogiadinh(h);
        u.setThoigian(Instant.now());
        unghoRepository.save(u);
    }

    @Override
    public UnghoDTO addFamilyintoDonate(String idFamily, String idDonate, int amount) {
        UnghoEntity unghoEntity = new UnghoEntity();
        Optional<DonggopEntity> donggopEntity = donggopRepository.findById(idDonate);
        HogiadinhEntity hogiadinhEntity = hogiadinhRepository.getOne(idFamily);
        unghoEntity.setHogiadinh(hogiadinhEntity);
        unghoEntity.setDonggop(donggopRepository.getById(idDonate));
        unghoEntity.setSotien(amount);
        unghoEntity.setThoigian(Instant.now());
        unghoEntity = unghoRepository.save(unghoEntity);
        return unghoConverter.toDTO(unghoEntity);
    }

}
