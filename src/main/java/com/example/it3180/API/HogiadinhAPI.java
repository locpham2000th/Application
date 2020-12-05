package com.example.it3180.API;

import com.example.it3180.DTO.quanLyHoGiaDinh.HogiadinhDTO;
import com.example.it3180.Service.quanLyHoGiaDinh.HogiadinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class HogiadinhAPI {

    @Autowired
    private HogiadinhService hogiadinhService;

    //chức năng thêm hộ gia đình
//    @PostMapping(value = "/hogiadinh")
//    public HogiadinhDTO addhogiadinh(@Validated String id, String hotenchuho, int   sonhankhau, String diachi,int trangthai){
//        return hogiadinhService.addhogiadinh(id, hotenchuho, sonhankhau, diachi, trangthai);
//    }
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

}
