package com.example.it3180.Repository;

import com.example.it3180.Entity.DonggopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DonggopRepository extends JpaRepository<DonggopEntity, String> {


    @Query("select  d from DonggopEntity d where d.TenDongGop like %?1%")
    DonggopEntity getByTenDongGop(String tenDongGop);

    DonggopEntity getById(String id);
}
