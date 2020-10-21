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

}
