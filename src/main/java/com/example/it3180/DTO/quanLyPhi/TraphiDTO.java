package com.example.it3180.DTO.quanLyPhi;

import javax.persistence.Column;
import java.time.Instant;
import java.time.LocalDate;

public class TraphiDTO {

    private Long id;
    private LocalDate thoigiandong;
    private String hogiadinh_id;
    private String phi_id;

    public String getHogiadinh_id() {
        return hogiadinh_id;
    }

    public void setHogiadinh_id(String hogiadinh_id) {
        this.hogiadinh_id = hogiadinh_id;
    }

    public String getPhi_id() {
        return phi_id;
    }

    public void setPhi_id(String phi_id) {
        this.phi_id = phi_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getThoigiandong() {
        return thoigiandong;
    }

    public void setThoigiandong(LocalDate thoigiandong) {
        this.thoigiandong = thoigiandong;
    }
}
