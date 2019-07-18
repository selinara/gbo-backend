package com.chl.gbo.cental.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: BoYanG
 * @Describe 登录-首页
 */
@Controller
public class LoginController {

    private static final Log  logger = LogFactory.getLog(LoginController.class);

    @GetMapping(value = "/login")
    public String login(){
        logger.info("=====================login==============");
        return "login";
    }

    @GetMapping(value = "/home")
    public String homePage(){
        logger.info("=====================home==============");
        return "home_page";
    }

    @RequestMapping(value = "/index")
    public String index(Model model,Authentication authentication){
        logger.info(authentication.getName()+" has login backend!!!!");
        model.addAttribute("currentUser", authentication.getName());
        return "index";
    }

    @GetMapping(value = "/no/permission")
    public String error(){
        return "no_permission";
    }

    @GetMapping(value = "/logout")
    public String logout(){
        return "login";
    }


}
