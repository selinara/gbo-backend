package com.chl.gbo.cental.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: BoYanG
 * @Describe 登录
 */
@Controller
public class LoginController {

    private static final Log  logger = LogFactory.getLog(LoginController.class);

    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }

    @PostMapping(value = "/login")
    public String login2(){
        return "login";
    }

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request){
        logger.info("index parameter" + request.getParameter("username"));
        return "index";
    }

    @GetMapping(value = "/error")
    public String error(){
        return "error";
    }

    @GetMapping(value = "/logout")
    public String logout(){
        return "login";
    }


}
