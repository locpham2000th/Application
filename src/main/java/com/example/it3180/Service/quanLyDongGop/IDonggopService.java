package com.example.it3180.Service.quanLyDongGop;

import com.example.it3180.DTO.quanLyDongGop.DonggopDTO;
import com.example.it3180.Entity.DonggopEntity;

import java.util.List;

public interface IDonggopService {
    List<DonggopDTO> search(String id, String name);

    DonggopDTO addDongGop(String id, String tenDongGop, String mucDich);

    Long countHoGiaDinh(String id);

    Long sumMoney(String id);

    void update(String id, String tenDongGop, String mucDich);



}
