package com.example.it3180.Converter;

import com.example.it3180.DTO.PhiDTO;
import com.example.it3180.Entity.PhiEntity;
import org.springframework.stereotype.Component;

@Component
public class PhiConverter {

    public PhiEntity toEntity(PhiDTO phiDTO){
        PhiEntity phiEntity = new PhiEntity();
        phiEntity.setDonGia(phiDTO.getDonGia());
        phiEntity.setMucDich(phiDTO.getMucDich());
        phiEntity.setTenPhi(phiDTO.getTenPhi());
        phiEntity.setThoiGianThu(phiDTO.getThoiGianThu());
        return phiEntity;
    }

    public PhiDTO toDTO(PhiEntity phiEntity){
        PhiDTO phiDTO = new PhiDTO();
        phiDTO.setId(phiEntity.getId());
        phiDTO.setDonGia(phiEntity.getDonGia());
        phiDTO.setMucDich(phiEntity.getMucDich());
        phiDTO.setTenPhi(phiEntity.getTenPhi());
        phiDTO.setThoiGianThu(phiEntity.getThoiGianThu());
        return phiDTO;
    }

}
