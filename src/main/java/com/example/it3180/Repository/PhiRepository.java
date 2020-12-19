package com.example.it3180.Repository;

import com.example.it3180.Entity.PhiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhiRepository extends JpaRepository<PhiEntity, String> {

    @Query(value = "select count(p.id) from PhiEntity p ")
    Long countunpaidfee();

    @Query(value = "select p from PhiEntity p where (p.id like %?1% and p.TenPhi like %?2%)")
    List<PhiEntity> findFeeByAll(String code, String name);

    @Query(value = "select p from PhiEntity p where p.TenPhi like %?1%")
    List<PhiEntity> findFeeByName(String name);

    @Query(value = "select count(t.id) from TraphiEntity t left join PhiEntity p on p.id = t.phi_traphi where p.id = ?1")
    Long countPaidFamily(String code);

    @Query(value = "select sum(p.DonGia * h.SoNhanKhau) from PhiEntity p left join TraphiEntity t on p.id = t.phi_traphi left join HogiadinhEntity h on h.id = t.hogiadinh_traphi where p.id = ?1")
    Long calTotalAmount(String code);
}
