package com.example.it3180.DTO.quanLyPhi;

import javax.persistence.Column;
import java.time.Instant;
import java.time.LocalDate;

public class PhiDTO {

    private String id;
    private String TenPhi;
    private LocalDate ThoiGianThu;
    private int DonGia;
    private String MucDich;
    private String link;

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

    public LocalDate getThoiGianThu() {
        return ThoiGianThu;
    }

    public void setThoiGianThu(LocalDate thoiGianThu) {
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
