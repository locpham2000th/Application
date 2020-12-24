package com.example.it3180.Service.quanLyDongGop;

import com.example.it3180.DTO.quanLyDongGop.DonggopDTO;
import com.example.it3180.DTO.quanLyDongGop.UnghoDTO;
import com.example.it3180.Entity.DonggopEntity;
import com.example.it3180.Entity.HogiadinhEntity;

import java.time.Instant;

public interface IUnghoService {

    void addUngHo(int soTien, String idDongGop, String idHoGiaDinh);

    UnghoDTO addFamilyintoDonate(String idFamily, String idDonate, int amount);

}
