package com.example.it3180.Converter.quanLyPhi;

import com.example.it3180.DTO.quanLyPhi.PhiDTO;
import com.example.it3180.Entity.PhiEntity;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class PhiConverter {

    public static LocalDate oldDateToLocalDate(Instant instant)
    {
        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        System.out.println(localDate);
        return localDate;
    }

    public PhiEntity toEntity(PhiDTO phiDTO){
        PhiEntity phiEntity = new PhiEntity();
        phiEntity.setDonGia(phiDTO.getDonGia());
        phiEntity.setMucDich(phiDTO.getMucDich());
        phiEntity.setTenPhi(phiDTO.getTenPhi());
//        phiEntity.setThoiGianThu(phiDTO.getThoiGianThu());
        return phiEntity;
    }

    public PhiDTO toDTO(PhiEntity phiEntity){
        PhiDTO phiDTO = new PhiDTO();
        phiDTO.setId(phiEntity.getId());
        phiDTO.setDonGia(phiEntity.getDonGia());
        phiDTO.setMucDich(phiEntity.getMucDich());
        phiDTO.setTenPhi(phiEntity.getTenPhi());
        phiDTO.setThoiGianThu(oldDateToLocalDate(phiEntity.getThoiGianThu()));
        return phiDTO;
    }

}
