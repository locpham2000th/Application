package com.example.it3180.Converter.quanLyPhi;

import com.example.it3180.DTO.quanLyPhi.TraphiDTO;
import com.example.it3180.Entity.TraphiEntity;
import com.example.it3180.Repository.HogiadinhRepository;
import com.example.it3180.Repository.PhiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

@Component
public class TraphiConverter {

    @Autowired
    private HogiadinhRepository hogiadinhRepository;

    @Autowired
    private PhiRepository phiRepository;

    public static LocalDate oldDateToLocalDate(Instant instant)
    {
        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        System.out.println(localDate);
        return localDate;
    }

    public TraphiEntity toEntity(TraphiDTO traphiDTO){
        TraphiEntity traphiEntity = new TraphiEntity();
        traphiEntity.setHogiadinh(hogiadinhRepository.getOne(traphiDTO.getHogiadinh_id()));
        traphiEntity.setPhi(phiRepository.getOne(traphiDTO.getPhi_id()));
//        traphiEntity.setThoigiandong(traphiDTO.getThoigiandong());
        return traphiEntity;
    }

    public TraphiDTO toDTO(TraphiEntity traphiEntity){
        TraphiDTO traphiDTO = new TraphiDTO();
        traphiDTO.setId(traphiEntity.getId());
        traphiDTO.setHogiadinh_id(traphiEntity.getHogiadinh().getId());
        traphiDTO.setPhi_id(traphiEntity.getPhi().getId());
        traphiDTO.setThoigiandong(oldDateToLocalDate(traphiEntity.getThoigiandong()));
        return traphiDTO;
    }

}
