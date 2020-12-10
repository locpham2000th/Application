package com.example.it3180.Service.quanLyHoGiaDinh;

import com.example.it3180.DTO.quanLyHoGiaDinh.HogiadinhDTO;

import java.util.List;

public interface IHogiadinhServer {

    String addhogiadinh(String id, String hotenchuho, int sonhankhau, String diachi,int trangthai);
    HogiadinhDTO edithogiadinh(String id, String hotenchuho, int sonhankhau, String diachi, int trangthai);
    String deletehogiadinh(String id);
    List<HogiadinhDTO> showhogiadinhByname(String hotenchuho);
    List<HogiadinhDTO> showHogiadinhByDiachi(String diachi);

    HogiadinhDTO showin4(String id);
    Long countpaidfee(String id);

    Long counttotal(String id);

}
