package com.example.it3180.Converter;

import com.example.it3180.DTO.DonggopDTO;
import com.example.it3180.Entity.DonggopEntity;
import org.springframework.stereotype.Component;

@Component
public class DonggopConverter {

    public DonggopEntity toEntity(DonggopDTO donggopDTO){
        DonggopEntity donggopEntity = new DonggopEntity();
        donggopEntity.setMucdich(donggopDTO.getMucdich());
        donggopEntity.setTenDongGop(donggopDTO.getTenDongGop());
        return donggopEntity;
    }

    public DonggopDTO toDTO(DonggopEntity donggopEntity){
        DonggopDTO donggopDTO = new DonggopDTO();
        donggopDTO.setId(donggopEntity.getId());
        donggopDTO.setMucdich(donggopEntity.getMucdich());
        donggopDTO.setTenDongGop(donggopEntity.getTenDongGop());
        return donggopDTO;
    }

}
