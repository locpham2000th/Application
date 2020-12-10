package com.example.it3180.API;

import com.example.it3180.DTO.quanLyHoGiaDinh.HogiadinhDTO;
import com.example.it3180.Service.quanLyHoGiaDinh.HogiadinhService;
import com.example.it3180.Service.quanLyPhi.PhiService;
import com.sun.istack.Nullable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class HogiadinhAPI {

    private final HogiadinhService hogiadinhService;
    private final PhiService phiService;

    public HogiadinhAPI(HogiadinhService hogiadinhService, PhiService phiService) {
        this.hogiadinhService = hogiadinhService;
        this.phiService = phiService;
    }

    //post, get,put, delete
    @PostMapping(value = "/addhogiadinh")
    public String addhogiadinh(@Validated String id, String hotenchuho, int sonhanhkhau, String diachi){
        return hogiadinhService.addhogiadinh(id,hotenchuho, sonhanhkhau, diachi,0);
    }

    @PutMapping(value = "/edithogiadinh")
    public HogiadinhDTO edithogiadinh(@Validated String id, String hotenchuho, int sonhanhkhau, String diachi, int trangthai){
        return hogiadinhService.edithogiadinh(id, hotenchuho,sonhanhkhau,diachi,trangthai);
    }

    @DeleteMapping(value = "/deletehogiadinh")
    public String deletehogiadinh(@Validated String id){
        return hogiadinhService.deletehogiadinh(id);
    }

    @GetMapping(value = "/findhogiadinh")
    public List<HogiadinhDTO> findhogiadinh(@Validated String id, String hotenchuho, @Nullable Integer sonhanhkhau, String diachi, @Nullable Integer trangthai){
        return hogiadinhService.findByAll(id, hotenchuho, sonhanhkhau, diachi, trangthai);
    }

    @GetMapping(value = "/findhogiadinhByname")
    public List<HogiadinhDTO> findhogiadinhByname(@Validated String hotenchuho){
        return hogiadinhService.showhogiadinhByname(hotenchuho);
    }

    @GetMapping(value = "/showhogiadinhByDiachi")
    public List<HogiadinhDTO> showhogiadinhByDiachi(@Validated String diachi){
        return hogiadinhService.showHogiadinhByDiachi(diachi);
    }

    @GetMapping(value = "/showIn4")
    public HogiadinhDTO showIn4(@Validated String id){
        return hogiadinhService.showin4(id);
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

}
