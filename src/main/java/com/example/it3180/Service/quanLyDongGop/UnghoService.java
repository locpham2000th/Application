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

@Service
public class UnghoService implements IUnghoService {

    @Autowired
    UnghoRepository unghoRepository;
    DonggopRepository donggopRepository;
    HogiadinhRepository hogiadinhRepository;

    @Override
    public void addUngHo(int soTien,  long idDongGop, String idHoGiaDinh) {
        DonggopEntity d = donggopRepository.getById(idDongGop);
        HogiadinhEntity h = hogiadinhRepository.getById(idHoGiaDinh);
        UnghoEntity u = new UnghoEntity();
        u.setSotien(soTien);
        u.setThoigian(Instant.now());
        u.setDonggop_ungho(d);
        u.setHogiadinh_ungho(h);
        unghoRepository.save(u);
    }

    @Override
    public void updateUngHo(String idCanSua, int soTien) {
        HogiadinhEntity h = hogiadinhRepository.getById(idCanSua);
        UnghoEntity u = unghoRepository.getByHogiadinh_ungho(h);
        u.setSotien(soTien);
    }

    @Override
    public void remove(Long id) {
        UnghoEntity u = unghoRepository.getOne(id);
        unghoRepository.delete(u);
    }


}
