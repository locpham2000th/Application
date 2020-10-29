package com.example.it3180.API;

import com.example.it3180.DTO.HogiadinhDTO;
import com.example.it3180.Service.impl.HogiadinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class HogiadinhAPI {

    @Autowired
    private HogiadinhService hogiadinhService;

    //chức năng thêm hộ gia đình
    @PostMapping(value = "/hogiadinh")
    public HogiadinhDTO addhogiadinh(@Validated String id, String hotenchuho, int   sonhankhau, String diachi,int trangthai){
        return hogiadinhService.addhogiadinh(id, hotenchuho, sonhankhau, diachi, trangthai);
    }

}
