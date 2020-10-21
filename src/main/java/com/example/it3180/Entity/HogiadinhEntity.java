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
    private String Diachi;

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

}
