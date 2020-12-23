package com.example.it3180.Repository;

import com.example.it3180.Entity.HogiadinhEntity;
import com.example.it3180.Entity.UnghoEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UnghoRepository extends JpaRepository<UnghoEntity, Long> {

    @Query(value = "select u from UnghoEntity u where u.donggop_ungho.id like %?1%")
    UnghoEntity findUngHo(String idDongGop);

    @Query(value = "select count(u.id) from UnghoEntity u left join DonggopEntity d on d.id = u.donggop_ungho  where d.id= ?1")
    Long countHoGiaDinh(String id);

    @Query(value = "select sum(u.sotien) from UnghoEntity u left join DonggopEntity d on d.id = u.donggop_ungho where d.id= ?1 ")
    Long sumMoney(String id);
}
