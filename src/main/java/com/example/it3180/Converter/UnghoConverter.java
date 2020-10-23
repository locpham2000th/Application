package com.example.it3180.Converter;

import com.example.it3180.DTO.UnghoDTO;
import com.example.it3180.Entity.UnghoEntity;
import com.example.it3180.Repository.DonggopRepository;
import com.example.it3180.Repository.HogiadinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UnghoConverter {

    @Autowired
    private DonggopRepository donggopRepository;

    @Autowired
    private HogiadinhRepository hogiadinhRepository;

    public UnghoEntity toEntity(UnghoDTO unghoDTO){
        UnghoEntity unghoEntity = new UnghoEntity();
        unghoEntity.setDonggop_ungho(donggopRepository.getOne(unghoDTO.getDonggop_id()));
        unghoEntity.setHogiadinh_ungho(hogiadinhRepository.getOne(unghoDTO.getHogiadinh_id()));
        unghoEntity.setSotien(unghoDTO.getSotien());
        unghoEntity.setThoigian(unghoDTO.getThoigian());
        return unghoEntity;
    }

    public UnghoDTO toDTO(UnghoEntity unghoEntity){
        UnghoDTO unghoDTO = new UnghoDTO();
        unghoDTO.setId(unghoEntity.getId());
        unghoDTO.setDonggop_id(unghoEntity.getDonggop_ungho().getId());
        unghoDTO.setHogiadinh_id(unghoEntity.getHogiadinh_ungho().getId());
        unghoDTO.setSotien(unghoEntity.getSotien());
        unghoDTO.setThoigian(unghoEntity.getThoigian());
        return unghoDTO;
    }

}
