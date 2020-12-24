package com.example.it3180.Converter.quanLyDongGop;

import com.example.it3180.DTO.quanLyDongGop.DonggopDTO;
import com.example.it3180.Entity.DonggopEntity;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class DonggopConverter {

    public static LocalDate oldDateToLocalDate(Instant instant)
    {
        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        System.out.println(localDate);
        return localDate;
    }

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
        donggopDTO.setThoiGian(oldDateToLocalDate(donggopEntity.getThoiGian()));
        return donggopDTO;
    }

}
