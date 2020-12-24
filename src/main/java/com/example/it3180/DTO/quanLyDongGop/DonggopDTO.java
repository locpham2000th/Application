package com.example.it3180.DTO.quanLyDongGop;

import com.example.it3180.Entity.UnghoEntity;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DonggopDTO {

    private String id;

    private String TenDongGop;

    private String Mucdich;

    private String note;

    private LocalDate thoiGian;

    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public LocalDate getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(LocalDate thoiGian) {
        this.thoiGian = thoiGian;
    }
}
