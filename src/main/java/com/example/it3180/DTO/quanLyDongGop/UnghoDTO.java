package com.example.it3180.DTO.quanLyDongGop;

import javax.persistence.Column;
import java.time.Instant;
import java.time.LocalDate;

public class UnghoDTO {

    private Long id;
    private int sotien;
    private LocalDate thoigian;
    private String hogiadinh_id;
    private String donggop_id;

    public String getHogiadinh_id() {
        return hogiadinh_id;
    }

    public void setHogiadinh_id(String hogiadinh_id) {
        this.hogiadinh_id = hogiadinh_id;
    }

    public String getDonggop_id() {
        return donggop_id;
    }

    public void setDonggop_id(String donggop_id) {
        this.donggop_id = donggop_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSotien() {
        return sotien;
    }

    public void setSotien(int sotien) {
        this.sotien = sotien;
    }

    public LocalDate getThoigian() {
        return thoigian;
    }

    public void setThoigian(LocalDate thoigian) {
        this.thoigian = thoigian;
    }
}
