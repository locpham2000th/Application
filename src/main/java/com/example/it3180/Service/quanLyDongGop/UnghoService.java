package com.example.it3180.Service.quanLyDongGop;

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

@Service
public class UnghoService implements IUnghoService {

    @Autowired
    UnghoRepository unghoRepository;
    HogiadinhRepository hogiadinhRepository;
    DonggopRepository donggopRepository;

    @Override
    public void addUngHo(int soTien,  String idDongGop, String idHoGiaDinh) {
        DonggopEntity d = donggopRepository.getOne(idDongGop);
        HogiadinhEntity h = hogiadinhRepository.getOne(idHoGiaDinh);
        UnghoEntity u = new UnghoEntity();
        u.setSotien(soTien);
        u.setDonggop_ungho(d);
        u.setHogiadinh_ungho(h);
        u.setThoigian(Instant.now());
        unghoRepository.save(u);
    }





}
