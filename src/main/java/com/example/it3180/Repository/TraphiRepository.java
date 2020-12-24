package com.example.it3180.Repository;

import com.example.it3180.Entity.DonggopEntity;
import com.example.it3180.Entity.HogiadinhEntity;
import com.example.it3180.Entity.PhiEntity;
import com.example.it3180.Entity.TraphiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TraphiRepository extends JpaRepository<TraphiEntity, Long> {

    @Query(value = "select t from TraphiEntity t where t.hogiadinh.id = ?1 and t.phi.id = ?2")
    TraphiEntity findHogiadinhAndPhi(String idFamily, String idFee);

}
