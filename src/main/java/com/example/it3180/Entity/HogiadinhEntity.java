package com.example.it3180.Entity;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ho_gia_dinh")
public class HogiadinhEntity {

    @Id
    private String id;

    @Column(name = "ho_ten_chu_ho")
    private String HoTenChuHo;

    @Column(name = "so_nhan_khau")
    private int SoNhanKhau;

    @Column(name = "dia_chi")
    private String diachi;

    @Column(name = "trang_thai")
    private int TrangThai;

    @Column(name = "thoi_gian_den")
    private Instant ThoiGianDen;

    @Column(name = "thoi_gian_roi_di")
    private Instant ThoiGianRoiDi;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "hogiadinh_traphi")
    private List<TraphiEntity> traphi = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "hogiadinh_ungho")
    private List<UnghoEntity> ungho = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoTenChuHo() {
        return HoTenChuHo;
    }

    public void setHoTenChuHo(String hoTenChuHo) {
        HoTenChuHo = hoTenChuHo;
    }

    public int getSoNhanKhau() {
        return SoNhanKhau;
    }

    public void setSoNhanKhau(int soNhanKhau) {
        SoNhanKhau = soNhanKhau;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        diachi = diachi;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int trangThai) {
        TrangThai = trangThai;
    }

    public Instant getThoiGianDen() {
        return ThoiGianDen;
    }

    public void setThoiGianDen(Instant thoiGianDen) {
        ThoiGianDen = thoiGianDen;
    }

    public Instant getThoiGianRoiDi() {
        return ThoiGianRoiDi;
    }

    public void setThoiGianRoiDi(Instant thoiGianRoiDi) {
        ThoiGianRoiDi = thoiGianRoiDi;
    }

    public List<TraphiEntity> getTraphi() {
        return traphi;
    }

    public void setTraphi(List<TraphiEntity> traphi) {
        this.traphi = traphi;
    }

    public List<UnghoEntity> getUngho() {
        return ungho;
    }

    public void setUngho(List<UnghoEntity> ungho) {
        this.ungho = ungho;
    }
}
