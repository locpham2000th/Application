package com.example.it3180.Service.quanLyPhi;

import com.example.it3180.DTO.quanLyPhi.PhiDTO;

import java.util.List;

public interface IPhiService {

    String addFee(String code, String name, int amount, String purpose);
    PhiDTO editFee(String id, String newName, int newAmount, String newPurpose);

    PhiDTO findFeeByID(String code);
    List<PhiDTO> findFeeByName(String code);
    List<PhiDTO> findFeeByAll(String code, String name);

    Long countPaidFamily(String code);
    Long countUnpaidFamily(String code);
    Long calTotalAmount(String code);

}
