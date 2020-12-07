package com.example.it3180.Service.quanLyDongGop;

import com.example.it3180.DTO.quanLyDongGop.DonggopDTO;
import com.example.it3180.Entity.DonggopEntity;

import java.util.List;

public interface IDonggopService {
    DonggopDTO search(Long id);

    DonggopDTO addDongGop(String tenDongGop, String mucDich);

    int sumEntity();

    int sumMoney();

    void update(Long id, String tenDongGop, String mucDich);



}
