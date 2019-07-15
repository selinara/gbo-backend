package com.chl.gbo.cental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: BoYanG
 * @Describe 登录
 */
@Controller
public class LoginController {

    @GetMapping(value = "/login.do")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping(value = "/error")
    public String error(){
        return "error";
    }
}
