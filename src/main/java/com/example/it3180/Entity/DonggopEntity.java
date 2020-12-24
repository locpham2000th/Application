package com.example.it3180.Entity;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dong_gop")
public class DonggopEntity {

    @Id
    private String id;

    @Column(name = "ten_dong_gop")
    private String TenDongGop;

    @Column(name = "muc_dich")
    private String Mucdich;

    @Column(name = "thoi_gian")
    private Instant thoiGian;

    @Column(name = "ghi_chu")
    private String note;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "donggop")
    private List<UnghoEntity> ungho = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenDongGop() {
        return TenDongGop;
    }

    public void setTenDongGop(String tenDongGop) {
        TenDongGop = tenDongGop;
    }

    public String getMucdich() {
        return Mucdich;
    }

    public void setMucdich(String mucdich) {
        Mucdich = mucdich;
    }

    public List<UnghoEntity> getUngho() {
        return ungho;
    }

    public void setUngho(List<UnghoEntity> ungho) {
        this.ungho = ungho;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Instant getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Instant thoiGian) {
        this.thoiGian = thoiGian;
    }
}
