package com.example.it3180.Converter.quanLyHoGiaDInh;

import com.example.it3180.DTO.quanLyHoGiaDinh.HogiadinhDTO;
import com.example.it3180.Entity.HogiadinhEntity;
import org.springframework.stereotype.Component;

@Component
public class HogiadinhConverter {

    public HogiadinhEntity toEntity(HogiadinhDTO hogiadinhDTO){
        HogiadinhEntity hogiadinhEntity = new HogiadinhEntity();
        hogiadinhEntity.setId(hogiadinhDTO.getId());
        hogiadinhEntity.setDiaChi(hogiadinhDTO.getDiachi());
        hogiadinhEntity.setHoTenChuHo(hogiadinhDTO.getHoTenChuHo());
        hogiadinhEntity.setSoNhanKhau(hogiadinhDTO.getSoNhanKhau());
        hogiadinhEntity.setThoiGianDen(hogiadinhDTO.getThoiGianDen());
        hogiadinhEntity.setThoiGianRoiDi(hogiadinhDTO.getThoiGianRoiDi());
        hogiadinhEntity.setTrangThai(hogiadinhDTO.getTrangThai());
        return hogiadinhEntity;
    }

    public HogiadinhDTO toDTO(HogiadinhEntity hogiadinhEntity){
        HogiadinhDTO hogiadinhDTO = new HogiadinhDTO();
        hogiadinhDTO.setId(hogiadinhEntity.getId());
        hogiadinhDTO.setDiachi(hogiadinhEntity.getDiaChi());
        hogiadinhDTO.setHoTenChuHo(hogiadinhEntity.getHoTenChuHo());
        hogiadinhDTO.setSoNhanKhau(hogiadinhEntity.getSoNhanKhau());
        hogiadinhDTO.setThoiGianDen(hogiadinhEntity.getThoiGianDen());
        hogiadinhDTO.setThoiGianRoiDi(hogiadinhEntity.getThoiGianRoiDi());
        hogiadinhDTO.setTrangThai(hogiadinhEntity.getTrangThai());
        return hogiadinhDTO;
    }

}
