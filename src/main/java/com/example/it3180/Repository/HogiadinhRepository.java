package com.example.it3180.Repository;

import com.example.it3180.Entity.HogiadinhEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HogiadinhRepository extends JpaRepository<HogiadinhEntity, String> {

    HogiadinhEntity getById(String id);

    @Query(value = "select h from HogiadinhEntity h where h.id like %?1% and h.HoTenChuHo like %?2% and h.SoNhanKhau = ?3 and h.diaChi like %?4% and h.TrangThai = ?5" )
    List<HogiadinhEntity> findByTitle(String id, String hotenchuho, int sonhankhau, String diachi, int trangthai);

    @Query(value = "select h from HogiadinhEntity h where h.HoTenChuHo like %?1%")
    List<HogiadinhEntity> findhogiadinhByname(String hotenchuho);

    List<HogiadinhEntity> findAllByDiaChiContaining(String diachi);

    @Query(value = "select count(t.phi_traphi) from HogiadinhEntity h left join TraphiEntity t on h.id = t.hogiadinh_traphi where h.id = ?1")
    Long countpaidfee(String id);

    @Query(value = "select sum(p.DonGia)from HogiadinhEntity h left join TraphiEntity t on h.id = t.hogiadinh_traphi left join PhiEntity p on p.id = t.phi_traphi where h.id = ?1")
    Long countTotal(String id);

    @Query(value = "select count(h.id) from HogiadinhEntity h")
    Long countFamily();

}
