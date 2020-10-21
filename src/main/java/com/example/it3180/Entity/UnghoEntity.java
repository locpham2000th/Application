package com.example.it3180.Entity;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "ung_ho")
public class UnghoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "so_tien")
    private int sotien;

    @Column(name = "thoi_gian")
    private Instant thoigian;

    @ManyToOne(fetch = FetchType.LAZY)
    private HogiadinhEntity hogiadinh_ungho;

    @ManyToOne(fetch = FetchType.LAZY)
    private DonggopEntity donggop_ungho;

}
