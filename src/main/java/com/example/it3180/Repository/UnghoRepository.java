package com.example.it3180.Repository;

import com.example.it3180.Entity.HogiadinhEntity;
import com.example.it3180.Entity.UnghoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnghoRepository extends JpaRepository<UnghoEntity, Long> {
    UnghoEntity getByHogiadinh_ungho(HogiadinhEntity hogiadinhEntity);
}
