package com.example.it3180.DTO;

import javax.persistence.Column;
import java.time.Instant;

public class PhiDTO {

    private String id;
    private String TenPhi;
    private Instant ThoiGianThu;
    private int DonGia;
    private String MucDich;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenPhi() {
        return TenPhi;
    }

    public void setTenPhi(String tenPhi) {
        TenPhi = tenPhi;
    }

    public Instant getThoiGianThu() {
        return ThoiGianThu;
    }

    public void setThoiGianThu(Instant thoiGianThu) {
        ThoiGianThu = thoiGianThu;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int donGia) {
        DonGia = donGia;
    }

    public String getMucDich() {
        return MucDich;
    }

    public void setMucDich(String mucDich) {
        MucDich = mucDich;
    }
}
