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

    @Column(name = "thoi_gian_thu")
    private Instant ThoiGianThu;

    @Column(name = "don_gia")
    private int DonGia;

    @Column(name = "muc_dich")
    private String MucDich;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "phi_traphi")
    private List<TraphiEntity> traphi = new ArrayList<>();

}