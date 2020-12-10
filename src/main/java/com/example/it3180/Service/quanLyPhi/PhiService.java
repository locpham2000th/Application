package com.example.it3180.Service.quanLyPhi;

import com.example.it3180.Repository.PhiRepository;
import org.springframework.stereotype.Service;

@Service
public class PhiService implements IPhiService {

    private final PhiRepository phiRepository;

    public PhiService(PhiRepository phiRepository) {
        this.phiRepository = phiRepository;
    }

    public Long countunpaidfee(){
        return phiRepository.countunpaidfee();
    }

}
