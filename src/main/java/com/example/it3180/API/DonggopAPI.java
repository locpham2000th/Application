package com.example.it3180.API;


import com.example.it3180.DTO.quanLyDongGop.DonggopDTO;
import com.example.it3180.Service.quanLyDongGop.DonggopService;
import com.example.it3180.Service.quanLyDongGop.UnghoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RestController
public class DonggopAPI {
    @Autowired
    private DonggopService donggopService;

    @Autowired
    private UnghoService unghoService;

    @PostMapping(value = "/search")
    public List<DonggopDTO> DonggopDTO (@Validated String id, String name){
        return donggopService.search(id, name);
    }

    @PostMapping(value = "/input")
    public DonggopDTO DonggopDTO(@Validated String id, String tenDongGop, String mucDich){
        return donggopService.addDongGop(id, tenDongGop,mucDich);
    }
    @GetMapping(value = "/countHoGiaDinh/{id}")
    public Long countHoGiaDinh(@PathVariable String id){
        return donggopService.countHoGiaDinh(id);
    }

    @GetMapping(value = "/sumMoney/{id}")
    public Long sumMoney(@PathVariable String id){
        return donggopService.sumMoney(id);
    }

    @PutMapping(value = "/update")
    public void Update(@Validated String id, String tenDongGop, String mucDich){
        donggopService.update(id,tenDongGop, mucDich);
    }

    @PostMapping(value = "/addUngHo{id}")
    public String addUngHo(@PathVariable String idDongGop, int soTien, String idHoGiaDinh ){
        unghoService.addUngHo(soTien,idDongGop, idHoGiaDinh);
        return "Ok";
    }


}
