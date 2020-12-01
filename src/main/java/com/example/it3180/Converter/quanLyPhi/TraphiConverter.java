package com.example.it3180.Converter.quanLyPhi;

import com.example.it3180.DTO.quanLyPhi.TraphiDTO;
import com.example.it3180.Entity.TraphiEntity;
import com.example.it3180.Repository.HogiadinhRepository;
import com.example.it3180.Repository.PhiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TraphiConverter {

    @Autowired
    private HogiadinhRepository hogiadinhRepository;

    @Autowired
    private PhiRepository phiRepository;

    public TraphiEntity toEntity(TraphiDTO traphiDTO){
        TraphiEntity traphiEntity = new TraphiEntity();
        traphiEntity.setHogiadinh_traphi(hogiadinhRepository.getOne(traphiDTO.getHogiadinh_id()));
        traphiEntity.setPhi_traphi(phiRepository.getOne(traphiDTO.getPhi_id()));
        traphiEntity.setThoigiandong(traphiDTO.getThoigiandong());
        traphiEntity.setTrangthai(traphiDTO.getTrangthai());
        return traphiEntity;
    }

    public TraphiDTO toDTO(TraphiEntity traphiEntity){
        TraphiDTO traphiDTO = new TraphiDTO();
        traphiDTO.setId(traphiEntity.getId());
        traphiDTO.setHogiadinh_id(traphiEntity.getHogiadinh_traphi().getId());
        traphiDTO.setPhi_id(traphiEntity.getPhi_traphi().getId());
        traphiDTO.setTrangthai(traphiEntity.getTrangthai());
        return traphiDTO;
    }

}
