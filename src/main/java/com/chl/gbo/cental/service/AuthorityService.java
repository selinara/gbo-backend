package com.chl.gbo.cental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chl.gbo.cental.domain.Authority;
import com.chl.gbo.cental.domain.Role;
import com.chl.gbo.cental.repository.AuthorityRepository;

/**
 * @Auther: BoYanG
 * @Describe TODO
 */
@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private RoleService roleService;

    public Authority findAthorityByUrl(String dataUrl){
        List<Authority> result = authorityRepository.findByDataUrl(dataUrl);
        if (null != result && result.size() != 0) {
            return result.get(0);
        }
        return null;
    }

    public List<Role> getRoleListByMenuCode(String menuCode){
        return roleService.getAuthoritysByMenuCode(menuCode);
    }
}
