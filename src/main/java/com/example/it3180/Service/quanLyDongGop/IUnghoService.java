package com.example.it3180.Service.quanLyDongGop;

import com.example.it3180.DTO.quanLyDongGop.UnghoDTO;
import com.example.it3180.Entity.DonggopEntity;
import com.example.it3180.Entity.HogiadinhEntity;

import java.time.Instant;

public interface IUnghoService {

    void addUngHo(int soTien, long idDongGop, String idHoGiaDinh);

    void updateUngHo(String idCanSua, int soTien);

    void remove(Long id);
}
