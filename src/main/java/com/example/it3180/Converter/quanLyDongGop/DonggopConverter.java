package com.example.it3180.Converter.quanLyDongGop;

import com.example.it3180.DTO.quanLyDongGop.DonggopDTO;
import com.example.it3180.Entity.DonggopEntity;
import org.springframework.stereotype.Component;

@Component
public class DonggopConverter {

    public DonggopEntity toEntity(DonggopDTO donggopDTO){
        DonggopEntity donggopEntity = new DonggopEntity();
        donggopEntity.setId(donggopDTO.getId());
        donggopEntity.setMucdich(donggopDTO.getMucdich());
        donggopEntity.setTenDongGop(donggopDTO.getTenDongGop());
        donggopEntity.setNote(donggopDTO.getNote());
        return donggopEntity;
    }

    public DonggopDTO toDTO(DonggopEntity donggopEntity){
        DonggopDTO donggopDTO = new DonggopDTO();
        donggopDTO.setId(donggopEntity.getId());
        donggopDTO.setMucdich(donggopEntity.getMucdich());
        donggopDTO.setTenDongGop(donggopEntity.getTenDongGop());
        donggopDTO.setNote(donggopEntity.getNote());
        return donggopDTO;
    }

}
