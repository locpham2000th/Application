package com.example.it3180.API;

import com.example.it3180.DTO.quanLyHoGiaDinh.HogiadinhDTO;
import com.example.it3180.Service.quanLyHoGiaDinh.HogiadinhService;
import com.example.it3180.Service.quanLyPhi.PhiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
public class HogiadinhAPI {

    private final HogiadinhService hogiadinhService;
    private final PhiService phiService;
    private final HttpSession httpSession;

    public HogiadinhAPI(HogiadinhService hogiadinhService, PhiService phiService, HttpSession httpSession) {
        this.hogiadinhService = hogiadinhService;
        this.phiService = phiService;
        this.httpSession = httpSession;
    }

    //post, get,put, delete
    @PostMapping(value = "/addhogiadinh")
    public ResponseEntity addhogiadinh(@Validated String id, String hotenchuho, int sonhankhau, String diachi){
        Map<String, String> data = new HashMap<>();
        data.put("result", hogiadinhService.addhogiadinh(id,hotenchuho, sonhankhau, diachi,1));
        return new ResponseEntity(data, HttpStatus.OK);
//        return hogiadinhService.addhogiadinh(id,hotenchuho, sonhankhau, diachi,1);
    }

    @PutMapping(value = "/edithogiadinh")
    public HogiadinhDTO edithogiadinh(@Validated String id, String hotenchuho, int sonhanhkhau, String diachi){
        return hogiadinhService.edithogiadinh(id, hotenchuho,sonhanhkhau,diachi);
    }

    @PutMapping(value = "/deletehogiadinh")
    public String deletehogiadinh(@Validated String id){
        return hogiadinhService.deletehogiadinh(id);
    }

    @GetMapping(value = "/findhogiadinh")
    public ModelAndView findhogiadinh(@RequestParam(value = "id") String id, @RequestParam(value = "hotenchuho") String hotenchuho, @RequestParam(value = "street") String street){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("familysearchresult");

        List<HogiadinhDTO> results = hogiadinhService.findByAll(id, hotenchuho, street);
        modelAndView.addObject("results", results);
        return modelAndView;
    }

    @GetMapping(value = "/findhogiadinhByname")
    public List<HogiadinhDTO> findhogiadinhByname(@Validated String hotenchuho){
        return hogiadinhService.showhogiadinhByname(hotenchuho);
    }

    @GetMapping(value = "/showhogiadinhByDiachi")
    public List<HogiadinhDTO> showhogiadinhByDiachi(@Validated String diachi){
        return hogiadinhService.showHogiadinhByDiachi(diachi);
    }

    @GetMapping(value = "/showIn4/{id}")
    public ModelAndView showIn4(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("familyprofile");
        HogiadinhDTO hogiadinhDTO = hogiadinhService.showin4(id);
        modelAndView.addObject("profile", hogiadinhDTO);
        modelAndView.addObject("unpaidFee",phiService.countunpaidfee() - hogiadinhService.countpaidfee(id));
        modelAndView.addObject("paidFee",hogiadinhService.countpaidfee(id));
        modelAndView.addObject("total",hogiadinhService.counttotal(id));
        if(String.valueOf(hogiadinhDTO.getTrangThai()).equals("1") ){
            modelAndView.addObject("state", "đang sinh sống" );
        }else {
            modelAndView.addObject("state","đã rời đi");
        }
        return modelAndView;
    }

    @GetMapping(value = "/countpaidfee")
    public Long countTraphi(@Validated String id){
        return hogiadinhService.countpaidfee(id);
    }

    @GetMapping(value = "/countunpaidfee/{id}")
    public Long countPhi(@PathVariable String id){
        Long unpaidfee = phiService.countunpaidfee() - hogiadinhService.countpaidfee(id);
        return unpaidfee;
    }

    @GetMapping(value = "/counttotaldonation/{id}")
    public Long countTotal(@PathVariable String id){
        return hogiadinhService.counttotal(id);
    }

    @PutMapping(value = "/editdiachi/{id}")
    public HogiadinhDTO editdiachi(@PathVariable String id, @Validated String diachi){
        return hogiadinhService.editdiachi(id,diachi);
    }

}
