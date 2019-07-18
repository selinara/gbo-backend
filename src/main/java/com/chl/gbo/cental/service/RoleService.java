package com.chl.gbo.cental.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chl.gbo.cental.domain.Role;
import com.chl.gbo.cental.repository.RoleRepository;

/**
 * @Auther: BoYanG
 * @Describe role
 */
@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getRolesByUserName(String username){
        return roleRepository.getRolesByUserName(username);
    }

    public List<Role> getAuthoritysByMenuCode(String menuCode){
        return roleRepository.getAuthoritysByMenuCode(menuCode);
    }

    public List<Role> findCurrentUserCheckRoleList(String ids) {
        String[] idArr = ids.split(",");
        List<Role> roleList = roleRepository.findAll();
        for (Role role : roleList) {
            for (String id : idArr) {
                if (id.equals(String.valueOf(role.getRoleId()))) {
                    role.setIsCheck(true);
                    break;
                }
            }
        }
        return roleList;
    }
}