package com.example.it3180.Service.quanLyPhi;

import com.example.it3180.Converter.quanLyPhi.TraphiConverter;
import com.example.it3180.Entity.TraphiEntity;
import com.example.it3180.Repository.HogiadinhRepository;
import com.example.it3180.Repository.PhiRepository;
import com.example.it3180.Repository.TraphiRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TraphiService implements ITraphiService {

    private final HogiadinhRepository hogiadinhRepository;
    private final PhiRepository phiRepository;
    private final TraphiConverter traphiConverter;
    private final TraphiRepository traphiRepository;

    public TraphiService(HogiadinhRepository hogiadinhRepository, PhiRepository phiRepository, TraphiConverter traphiConverter, TraphiRepository traphiRepository) {
        this.hogiadinhRepository = hogiadinhRepository;
        this.phiRepository = phiRepository;
        this.traphiConverter = traphiConverter;
        this.traphiRepository = traphiRepository;
    }

    @Override
    public String addFamilyIntoFee(String idFamily, String idFee) {
        TraphiEntity traphiEntity = new TraphiEntity();
        TraphiEntity traphiEntityold = traphiRepository.findHogiadinhAndPhi(idFamily,idFee);
        if(traphiEntityold == null){
            traphiEntity.setHogiadinh(hogiadinhRepository.getOne(idFamily));
            traphiEntity.setPhi(phiRepository.getOne(idFee));
            traphiEntity.setThoigiandong(Instant.now());
            traphiEntity = traphiRepository.save(traphiEntity);
            return "success";
        }else {
            return "error";
        }

    }

}
