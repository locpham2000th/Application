package com.example.it3180.Entity;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "phi")
public class PhiEntity {

    @Id
    private String id;

    @Column(name = "ten_phi")
    private String TenPhi;

    @Column(name = "thoi_gian")
    private Instant ThoiGian;

    @Column(name = "don_gia")
    private int DonGia;

    @Column(name = "muc_dich")
    private String MucDich;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "phi")
    private List<TraphiEntity> traphi = new ArrayList<>();

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
        return ThoiGian;
    }

    public void setThoiGianThu(Instant thoiGianThu) {
        ThoiGian = thoiGianThu;
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

    public List<TraphiEntity> getTraphi() {
        return traphi;
    }

    public void setTraphi(List<TraphiEntity> traphi) {
        this.traphi = traphi;
    }
}