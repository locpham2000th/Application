package com.example.it3180.API;

import com.example.it3180.DTO.quanLyPhi.PhiDTO;
import com.example.it3180.Service.quanLyHoGiaDinh.HogiadinhService;
import com.example.it3180.Service.quanLyPhi.PhiService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class PhiAPI {

    private final PhiService phiService;


    public PhiAPI(PhiService phiService, HogiadinhService hogiadinhService) {
        this.phiService = phiService;
    }

    @PostMapping(value = "/addfee") // ok
    public String addFee(@Validated String  code, String name, int amount, String purpose){
        return phiService.addFee(code, name, amount,purpose);
    }

    @PutMapping(value = "/editfee") // ok
    public PhiDTO editFee(@Validated String code, String newName, int newAmount, String newPurpose){
        return phiService.editFee(code, newName, newAmount, newPurpose);
    }

    @GetMapping(value = "/findfeebyid") // ok
    public PhiDTO findFeeByID(@Validated String code){
        return  phiService.findFeeByID(code);
    }

    @GetMapping(value = "/findfeebyname") // ok
    public List<PhiDTO> findFeeByName(@Validated String name){
        return phiService.findFeeByName(name);
    }

    @GetMapping(value = "/findfeebyall") // ok
    public List<PhiDTO> findFeeByALl(@Validated String code, String name){
        return phiService.findFeeByAll(code, name);
    }

    @GetMapping(value = "/countpaidfamily") // ok
    public Long countPaidFamily(@Validated String code){
        return phiService.countPaidFamily(code);
    }

    @GetMapping(value = "/countunpaidfamily") // ok
    public Long countUnpaidFamily(@Validated String code){
        return phiService.countUnpaidFamily(code);
    }

    @GetMapping(value = "/caltotalfeeamount") // ok
    public Long calTotalAmount(@Validated String code){
        return phiService.calTotalAmount(code);
    }
}
