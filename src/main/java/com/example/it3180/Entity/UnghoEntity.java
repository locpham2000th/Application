package com.example.it3180.Entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "ung_ho")
public class UnghoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "so_tien")
    private int sotien;

    @Column(name = "thoi_gian")
    private Instant thoigian;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hogiadinh_id")
    private HogiadinhEntity hogiadinh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "donggop_id")
    private DonggopEntity donggop;

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

    public HogiadinhEntity getHogiadinh() {
        return hogiadinh;
    }

    public void setHogiadinh(HogiadinhEntity hogiadinh) {
        this.hogiadinh = hogiadinh;
    }

    public DonggopEntity getDonggop() {
        return donggop;
    }

    public void setDonggop(DonggopEntity donggop) {
        this.donggop = donggop;
    }
}
