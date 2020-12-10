package com.example.it3180.API;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controller {

    @RequestMapping(value = "/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/searchfamily")
    public ModelAndView searchfamily(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("searchfamily");
        return modelAndView;
    }

    @RequestMapping(value = "/addfamily")
    public ModelAndView addfamily(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addfamily");
        return modelAndView;
    }

    @RequestMapping(value = "/familysearchresult")
    public ModelAndView familysearchresult(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("familysearchresult");
        return modelAndView;
    }

    @RequestMapping(value = "/feesearchresult")
    public ModelAndView feesearchresult(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("feesearchresult");
        return modelAndView;
    }

    @RequestMapping(value = "/donatesearchresult")
    public ModelAndView donatesearchresult(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("donatesearchresult");
        return modelAndView;
    }

    @RequestMapping(value = "/familyprofile")
    public ModelAndView familyprofile(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("familyprofile");
        return modelAndView;
    }

    @RequestMapping(value = "/feeprofile")
    public ModelAndView feeprofile(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("feeprofile");
        return modelAndView;
    }

    @RequestMapping(value = "/donateprofile")
    public ModelAndView donateprofile(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("donateprofile");
        return modelAndView;
    }

}
