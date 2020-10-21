package com.example.it3180.DTO;

import javax.persistence.Column;
import java.time.Instant;

public class HogiadinhDTO {

    private String id;
    private String HoTenChuHo;
    private int SoNhanKhau;
    private String Diachi;
    private int TrangThai;
    private Instant ThoiGianDen;
    private Instant ThoiGianRoiDi;

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
        return Diachi;
    }

    public void setDiachi(String diachi) {
        Diachi = diachi;
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
}
