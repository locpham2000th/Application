package com.example.it3180.DTO;

import javax.persistence.Column;
import java.time.Instant;

public class UnghoDTO {

    private int id;
    private int sotien;
    private Instant thoigian;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
