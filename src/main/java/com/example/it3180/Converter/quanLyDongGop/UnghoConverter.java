package com.example.it3180.Converter.quanLyDongGop;

import com.example.it3180.DTO.quanLyDongGop.UnghoDTO;
import com.example.it3180.Entity.UnghoEntity;
import com.example.it3180.Repository.DonggopRepository;
import com.example.it3180.Repository.HogiadinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class UnghoConverter {

    @Autowired
    private DonggopRepository donggopRepository;

    @Autowired
    private HogiadinhRepository hogiadinhRepository;

    public static LocalDate oldDateToLocalDate(Instant instant)
    {
        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        System.out.println(localDate);
        return localDate;
    }

    public UnghoEntity toEntity(UnghoDTO unghoDTO){
        UnghoEntity unghoEntity = new UnghoEntity();
        unghoEntity.setDonggop(donggopRepository.getOne(unghoDTO.getDonggop_id()));
        unghoEntity.setHogiadinh(hogiadinhRepository.getOne(unghoDTO.getHogiadinh_id()));
        unghoEntity.setSotien(unghoDTO.getSotien());
//        unghoEntity.setThoigian(unghoDTO.getThoigian());
        return unghoEntity;
    }

    public UnghoDTO toDTO(UnghoEntity unghoEntity){
        UnghoDTO unghoDTO = new UnghoDTO();
        unghoDTO.setId(unghoEntity.getId());
        unghoDTO.setDonggop_id(unghoEntity.getDonggop().getId());
        unghoDTO.setHogiadinh_id(unghoEntity.getHogiadinh().getId());
        unghoDTO.setSotien(unghoEntity.getSotien());
        unghoDTO.setThoigian(oldDateToLocalDate(unghoEntity.getThoigian()));
        return unghoDTO;
    }

}
