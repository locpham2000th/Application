package com.example.it3180.DTO;

import javax.persistence.Column;
import java.time.Instant;

public class UnghoDTO {

    private Long id;
    private int sotien;
    private Instant thoigian;
    private String hogiadinh_id;
    private Long donggop_id;

    public String getHogiadinh_id() {
        return hogiadinh_id;
    }

    public void setHogiadinh_id(String hogiadinh_id) {
        this.hogiadinh_id = hogiadinh_id;
    }

    public Long getDonggop_id() {
        return donggop_id;
    }

    public void setDonggop_id(Long donggop_id) {
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

    public Instant getThoigian() {
        return thoigian;
    }

    public void setThoigian(Instant thoigian) {
        this.thoigian = thoigian;
    }
}
