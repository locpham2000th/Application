package com.example.it3180.API;

import com.example.it3180.DTO.quanLyPhi.PhiDTO;
import com.example.it3180.DTO.quanLyPhi.TraphiDTO;
import com.example.it3180.Service.quanLyHoGiaDinh.HogiadinhService;
import com.example.it3180.Service.quanLyPhi.PhiService;
import com.example.it3180.Service.quanLyPhi.TraphiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
public class PhiAPI {

    private final PhiService phiService;
    private final TraphiService traphiService;


    public PhiAPI(PhiService phiService, HogiadinhService hogiadinhService, TraphiService traphiService) {
        this.phiService = phiService;
        this.traphiService = traphiService;
    }

    @PostMapping(value = "/addfee") // ok
    public ResponseEntity addFee(@Validated String  code, String name, int amount, String purpose){
        Map<String, String> data = new HashMap<>();
        data.put("result", phiService.addFee(code, name, amount,purpose));
        return new ResponseEntity(data, HttpStatus.OK);
//        return phiService.addFee(code, name, amount,purpose);
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
    public ModelAndView findFeeByALl(@RequestParam(name = "code") String code, @RequestParam(name = "name") String name){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("feesearchresult");
        modelAndView.addObject("resultFee",phiService.findFeeByAll(code, name));
        return modelAndView;
    }

    @GetMapping(value = "/in4Fee/{id}")
    public ModelAndView showIn4Fee(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("feeprofile");
        modelAndView.addObject("resultFee",phiService.findFeeByID(id));
        modelAndView.addObject("Unpaid",phiService.countUnpaidFamily(id));
        modelAndView.addObject("Paid",phiService.countPaidFamily(id));
        modelAndView.addObject("Total",phiService.calTotalAmount(id));
        return modelAndView;
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

    @PostMapping(value = "/addFamilyIntoFee")
    public ResponseEntity addFamilyIntoFee(@Validated String idFamily, String idFee){
        Map<String, String> data = new HashMap<>();
        data.put("result",traphiService.addFamilyIntoFee(idFamily,idFee));
        return new ResponseEntity(data, HttpStatus.OK);
    }

}
