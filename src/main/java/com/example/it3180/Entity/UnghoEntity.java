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
    private HogiadinhEntity hogiadinh_ungho;

    @ManyToOne(fetch = FetchType.LAZY)
    private DonggopEntity donggop_ungho;

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

    public HogiadinhEntity getHogiadinh_ungho() {
        return hogiadinh_ungho;
    }

    public void setHogiadinh_ungho(HogiadinhEntity hogiadinh_ungho) {
        this.hogiadinh_ungho = hogiadinh_ungho;
    }

    public DonggopEntity getDonggop_ungho() {
        return donggop_ungho;
    }

    public void setDonggop_ungho(DonggopEntity donggop_ungho) {
        this.donggop_ungho = donggop_ungho;
    }
}
