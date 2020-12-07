package com.example.it3180.API;


import com.example.it3180.DTO.quanLyDongGop.DonggopDTO;
import com.example.it3180.Service.quanLyDongGop.DonggopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DonggopAPI {
    @Autowired
    private DonggopService donggopService;

    @PostMapping(value = "/search")
    public DonggopDTO DonggopDTO (Long id){
        return donggopService.search(id);
    }

    @GetMapping(value = "/input")
    public DonggopDTO DonggopDTO(@Validated String tenDongGop, String mucDich){
        return donggopService.addDongGop(tenDongGop,mucDich);
    }

    @GetMapping(value = "sumEntity")
    public ResponseEntity<?> Sum(){
        int a = donggopService.sumEntity();
        return ResponseEntity.ok().body(a);
    }

    @GetMapping(value = "sumMoney")
    public ResponseEntity<?> SumMoney(){
        int a = donggopService.sumMoney();
        return ResponseEntity.ok().body(a);
    }

    @PutMapping(value = "update")
    public void Update(@Validated Long id, String tenDongGop, String mucDich){
        donggopService.update(id,tenDongGop, mucDich);
    }



}
