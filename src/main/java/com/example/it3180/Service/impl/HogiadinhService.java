package com.example.it3180.Service.impl;

import com.example.it3180.Converter.HogiadinhConverter;
import com.example.it3180.DTO.HogiadinhDTO;
import com.example.it3180.Entity.HogiadinhEntity;
import com.example.it3180.Repository.HogiadinhRepository;
import com.example.it3180.Service.IHogiadinhServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HogiadinhService implements IHogiadinhServer {

    @Autowired
    private HogiadinhConverter hogiadinhConverter;

    @Autowired
    private HogiadinhRepository hogiadinhRepository;

    @Override
    public HogiadinhDTO addhogiadinh(String id, String hotenchuho, int sonhankhau, String diachi,int trangthai) {
        HogiadinhEntity hogiadinhEntity = new HogiadinhEntity();
        hogiadinhEntity.setId(id);
        hogiadinhEntity.setHoTenChuHo(hotenchuho);
        hogiadinhEntity.setSoNhanKhau(sonhankhau);
        hogiadinhEntity.setDiachi(diachi);
        hogiadinhEntity.setTrangThai(0);
        hogiadinhEntity = hogiadinhRepository.save(hogiadinhEntity);
        return hogiadinhConverter.toDTO(hogiadinhEntity);
    }
}
