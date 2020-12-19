package com.example.it3180.Service.quanLyPhi;

import com.example.it3180.Converter.quanLyPhi.PhiConverter;
import com.example.it3180.DTO.quanLyPhi.PhiDTO;
import com.example.it3180.Entity.PhiEntity;
import com.example.it3180.Repository.PhiRepository;
import com.example.it3180.Service.quanLyHoGiaDinh.HogiadinhService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhiService implements IPhiService {

    private final PhiRepository phiRepository;
    private final PhiConverter phiConverter;
    private final HogiadinhService hogiadinhService;

    public PhiService(PhiRepository phiRepository, PhiConverter phiConverter, HogiadinhService hogiadinhService) {
        this.phiRepository = phiRepository;
        this.phiConverter = phiConverter;
        this.hogiadinhService = hogiadinhService;
    }

    public Long countunpaidfee(){
        return phiRepository.countunpaidfee();
    }

    @Override
    public String addFee(String code, String name, int amount, String purpose) { // ok
        PhiEntity phiEntity = new PhiEntity();
        try{
            phiEntity.setId(code);
            phiEntity.setTenPhi(name);
            phiEntity.setDonGia(amount);
            phiEntity.setMucDich(purpose);
            phiEntity.setThoiGianThu(Instant.now());
            phiRepository.save(phiEntity);
            return "Success";
        }catch(Exception e){
            return e.getMessage();
        }

    }

    @Override
    public PhiDTO editFee(String id, String newName, int newAmount, String newPurpose) { //ok
        PhiEntity phiEntity = phiRepository.getOne(id);
        phiEntity.setTenPhi(newName);
        phiEntity.setDonGia(newAmount);
        phiEntity.setMucDich(newPurpose);
        phiRepository.save(phiEntity);
        return phiConverter.toDTO(phiEntity);
    }

    @Override
    public PhiDTO findFeeByID(String code) { // ok
        PhiEntity phiEntity = phiRepository.getOne(code);
        return phiConverter.toDTO(phiEntity);
    }

    @Override
    public List<PhiDTO> findFeeByName(String name) { // ok
        List<PhiDTO> phiDTOS = new ArrayList<>();
        List<PhiEntity> phiEntities = phiRepository.findFeeByName(name);
        for(int i = 0; i < phiEntities.size(); i++){
            phiDTOS.add(phiConverter.toDTO(phiEntities.get(i)));
        }

        return phiDTOS;
    }

    @Override
    public List<PhiDTO> findFeeByAll(String code, String name) { // ok
        List<PhiDTO> phiDTOS = new ArrayList<>();
        List<PhiEntity> phiEntities = phiRepository.findFeeByAll(code, name);
        for(int i = 0; i < phiEntities.size(); i++){
            phiDTOS.add(phiConverter.toDTO(phiEntities.get(i)));
        }

        return phiDTOS;
    }


    @Override
    public Long countPaidFamily(String code) { // ok
        return phiRepository.countPaidFamily(code);
    }

    @Override
    public Long countUnpaidFamily(String code) {
        return hogiadinhService.countFamily() - phiRepository.countPaidFamily(code);
    }

    @Override
    public Long calTotalAmount(String code) {
        Long total = phiRepository.calTotalAmount(code);
        if(total == null) return new Long(0);
        else return total;
    }

}
