package com.example.it3180.Entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tra_phi")
public class TraphiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hogiadinh_id")
    private HogiadinhEntity hogiadinh_traphi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phi_id")
    private PhiEntity phi_traphi;

    @Column(name = "trang_thai")
    private int trangthai;

    @Column(name = "thoi_gian_dong")
    private Instant thoigiandong;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HogiadinhEntity getHogiadinh_traphi() {
        return hogiadinh_traphi;
    }

    public void setHogiadinh_traphi(HogiadinhEntity hogiadinh_traphi) {
        this.hogiadinh_traphi = hogiadinh_traphi;
    }

    public PhiEntity getPhi_traphi() {
        return phi_traphi;
    }

    public void setPhi_traphi(PhiEntity phi_traphi) {
        this.phi_traphi = phi_traphi;
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
