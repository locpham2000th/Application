package com.example.it3180.DTO;

import javax.persistence.Column;
import java.time.Instant;

public class TraphiDTO {

    private Long id;
    private int trangthai;
    private Instant thoigiandong;

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
