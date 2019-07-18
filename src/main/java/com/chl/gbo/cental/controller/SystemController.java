package com.chl.gbo.cental.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chl.gbo.cental.domain.Role;
import com.chl.gbo.cental.domain.User;
import com.chl.gbo.cental.repository.RoleRepository;
import com.chl.gbo.cental.repository.UserRepository;
import com.chl.gbo.cental.service.RoleService;
import com.chl.gbo.cental.service.UserService;
import com.google.common.collect.Maps;

/**
 * @Auther: BoYanG
 * @Describe 后台系统管理
 */
@Controller
@RequestMapping("/system")
public class SystemController {

    private static final Log logger = LogFactory.getLog(SystemController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/user")
    public String systemUserPage(Model model){
        model.addAttribute("userList", userService.findAllUsers());
        return "/system/system_user";
    }

    @GetMapping("/user/edit")
    public String userEdit(String ud, String un, String ids, Model model){
        model.addAttribute("ud", ud);
        model.addAttribute("un", un);
        model.addAttribute("roles", roleService.findCurrentUserCheckRoleList(ids));
        return "/system/system_user_aded";
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
