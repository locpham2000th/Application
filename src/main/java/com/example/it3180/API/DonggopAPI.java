package com.example.it3180.API;


import com.example.it3180.DTO.quanLyDongGop.DonggopDTO;
import com.example.it3180.DTO.quanLyDongGop.UnghoDTO;
import com.example.it3180.Service.quanLyDongGop.DonggopService;
import com.example.it3180.Service.quanLyDongGop.UnghoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RestController
public class DonggopAPI {
    @Autowired
    private DonggopService donggopService;

    @Autowired
    private UnghoService unghoService;

    @GetMapping(value = "/search")
    public ModelAndView DonggopDTO (@RequestParam(name = "id") String id,@RequestParam(name = "tenDongGop") String name){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("donatesearchresult");
        List<DonggopDTO> donggopDTOS = donggopService.search(id, name);
        modelAndView.addObject("resultsDonate",donggopDTOS);
        return modelAndView;
    }

    @PostMapping(value = "/input")
    public DonggopDTO DonggopDTO(@Validated String id, String tenDongGop, String mucDich,String note){
        return donggopService.addDongGop(id, tenDongGop,mucDich,note);
    }

    @GetMapping(value = "/in4Donate/{id}")
    public ModelAndView showIn4(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("donateprofile");
        modelAndView.addObject("profileDonate", donggopService.showIn4(id));
        modelAndView.addObject("sumMoney",donggopService.sumMoney(id));
        modelAndView.addObject("countHoGiaDinh", donggopService.countHoGiaDinh(id));
        return modelAndView;
    }

        @GetMapping(value = "/countHoGiaDinh/{id}")
    public Long countHoGiaDinh(@PathVariable String id){
        return donggopService.countHoGiaDinh(id);
    }

    @GetMapping(value = "/sumMoney/{id}")
    public Long sumMoney(@PathVariable String id){
        return donggopService.sumMoney(id);
    }

    @PutMapping(value = "/update")
    public void Update(@Validated String id, String tenDongGop, String mucDich){
        donggopService.update(id,tenDongGop, mucDich);
    }

    @PostMapping(value = "/addUngHo{id}")
    public String addUngHo(@PathVariable String idDongGop, int soTien, String idHoGiaDinh ){
        unghoService.addUngHo(soTien,idDongGop, idHoGiaDinh);
        return "Ok";
    }

    @PutMapping(value = "/editDonate")
    public DonggopDTO editDongGop(@Validated String id, String name, String purpose, String note){
        return donggopService.editDongGop(id,name,purpose,note);
    }

    @PostMapping(value = "/addFamilyintoDonate")
    public UnghoDTO addFamilyintoDonate(@Validated String idFamily, String idDonate,int amount){
        return unghoService.addFamilyintoDonate(idFamily,idDonate,amount);
    }


}
