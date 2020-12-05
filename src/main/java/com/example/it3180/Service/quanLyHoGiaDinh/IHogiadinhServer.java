package com.example.it3180.Service.quanLyHoGiaDinh;

import com.example.it3180.DTO.quanLyHoGiaDinh.HogiadinhDTO;

public interface IHogiadinhServer {

    String addhogiadinh(String id, String hotenchuho, int sonhankhau, String diachi,int trangthai);
    HogiadinhDTO edithogiadinh(String id, String hotenchuho, int sonhankhau, String diachi, int trangthai);
    String deletehogiadinh(String id);
}
