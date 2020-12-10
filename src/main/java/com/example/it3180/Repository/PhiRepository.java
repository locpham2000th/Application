package com.example.it3180.Repository;

import com.example.it3180.Entity.PhiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PhiRepository extends JpaRepository<PhiEntity, String> {

    @Query(value = "select count(p.id) from PhiEntity p ")
    Long countunpaidfee();

}
