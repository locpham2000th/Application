package com.example.it3180.DTO;

import javax.persistence.Column;
import java.time.Instant;

public class TraphiDTO {

    private Long id;
    private int trangthai;
    private Instant thoigiandong;
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

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public Instant getThoigiandong() {
        return thoigiandong;
    }

    public void setThoigiandong(Instant thoigiandong) {
        this.thoigiandong = thoigiandong;
    }
}
