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

}
