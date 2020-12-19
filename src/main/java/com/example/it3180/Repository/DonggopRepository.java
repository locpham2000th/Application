package com.example.it3180.Repository;

import com.example.it3180.Entity.DonggopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DonggopRepository extends JpaRepository<DonggopEntity, String> {


    @Query("select  d from DonggopEntity d where d.TenDongGop like %?1%")
    List<DonggopEntity> getByTenDongGop(String tenDongGop);

    @Query("select d from DonggopEntity d where d.id like %?1%")
    List<DonggopEntity> getByIdDongGop(String id);

    DonggopEntity getById(String id);
}
