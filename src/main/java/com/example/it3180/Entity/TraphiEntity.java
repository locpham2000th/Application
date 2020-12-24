package com.example.it3180.Entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tra_phi")
public class TraphiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hogiadinh_id")
    private HogiadinhEntity hogiadinh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phi_id")
    private PhiEntity phi;

    @Column(name = "thoi_gian_dong")
    private Instant thoigiandong;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HogiadinhEntity getHogiadinh() {
        return hogiadinh;
    }

    public void setHogiadinh(HogiadinhEntity hogiadinh) {
        this.hogiadinh = hogiadinh;
    }

    public PhiEntity getPhi() {
        return phi;
    }

    public void setPhi(PhiEntity phi) {
        this.phi = phi;
    }

    public Instant getThoigiandong() {
        return thoigiandong;
    }

    public void setThoigiandong(Instant thoigiandong) {
        this.thoigiandong = thoigiandong;
    }
}
