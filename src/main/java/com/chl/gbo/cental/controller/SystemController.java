package com.chl.gbo.cental.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: BoYanG
 * @Describe 后台系统管理
 */
@Controller
@RequestMapping("/system")
public class SystemController {

    private static final Log logger = LogFactory.getLog(SystemController.class);

    @GetMapping("/user")
    public String systemUserPage(){
        return "/system/system_user";
    }
    @GetMapping("/role")
    public String systemRolePage(){
        return "";
    }

    @GetMapping("/page")
    public String systemAuthorityPage(){
        return "";
    }


}
