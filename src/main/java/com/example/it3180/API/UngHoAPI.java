package com.example.it3180.API;

import com.example.it3180.Service.quanLyDongGop.UnghoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UngHoAPI {
    @Autowired
    UnghoService unghoService;

    @PostMapping("ungho/add")
    public void addUngHo(@Validated int soTien, long idDongGop, String idHoGiaDinh){
        unghoService.addUngHo(soTien, idDongGop, idHoGiaDinh);
    }

    @PutMapping("ungho/update")
    public void update(String idCanSua, int soTien){
        unghoService.updateUngHo(idCanSua, soTien);
    }

    @PostMapping("ungho/delete")
    public void delete(Long id){
        unghoService.remove(id);
    }
}
