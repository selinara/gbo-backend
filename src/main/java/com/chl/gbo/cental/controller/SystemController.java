package com.chl.gbo.cental.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.chl.gbo.cental.domain.User;
import com.chl.gbo.cental.service.RoleService;
import com.chl.gbo.cental.service.UserService;

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

    @GetMapping("/user/add")
    public String userEdit(Model model){
        model.addAttribute("roles", roleService.findCurrentUserCheckRoleList(null));
        model.addAttribute("tip", "ADD");
        return "/system/system_user_aded";
    }

    @GetMapping("/user/edit")
    public String userEdit(String ud, String un, String ids, Model model){
        model.addAttribute("ud", ud);
        model.addAttribute("un", un);
        model.addAttribute("roles", roleService.findCurrentUserCheckRoleList(ids));
        model.addAttribute("tip", "EDIT");
        return "/system/system_user_aded";
    }

    @PostMapping("/user/submit")
    public String userSubmit(User user){
        userService.insertUser(user);
        return "redirect:/system/user";
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
