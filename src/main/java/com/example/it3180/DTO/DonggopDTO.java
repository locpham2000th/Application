package com.example.it3180.DTO;

import com.example.it3180.Entity.UnghoEntity;

import java.util.ArrayList;
import java.util.List;

public class DonggopDTO {

    private Long id;

    private String TenDongGop;

    private String Mucdich;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenDongGop() {
        return TenDongGop;
    }

    public void setTenDongGop(String tenDongGop) {
        TenDongGop = tenDongGop;
    }

    public String getMucdich() {
        return Mucdich;
    }

    public void setMucdich(String mucdich) {
        Mucdich = mucdich;
    }

}
