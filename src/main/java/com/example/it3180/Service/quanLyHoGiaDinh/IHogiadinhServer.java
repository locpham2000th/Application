package com.example.it3180.Service.quanLyHoGiaDinh;

import com.example.it3180.DTO.quanLyHoGiaDinh.HogiadinhDTO;

public interface IHogiadinhServer {

    HogiadinhDTO addhogiadinh(String id, String hotenchuho, int sonhankhau, String diachi,int trangthai);

}
