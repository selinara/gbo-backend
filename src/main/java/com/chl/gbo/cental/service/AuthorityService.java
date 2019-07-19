package com.chl.gbo.cental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.chl.gbo.cental.domain.Authority;
import com.chl.gbo.cental.domain.Role;
import com.chl.gbo.cental.repository.AuthorityRepository;
import com.chl.gbo.util.DateUtil;

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

    public List<Authority> findAll() {
        Sort sort = new Sort(Sort.Direction.ASC, "sequence");
        return authorityRepository.findAll(sort);
    }

    public void deleteAuthInfoByCode(String code) {
        if (StringUtils.isEmpty(code)) {
            return;
        }

        //role-authority
        authorityRepository.deleteRoleAuth(code);

        //role
        authorityRepository.deleteByMenuCode(code);
    }

    public void insertAuthority(Authority authority) {
        authority.setCreateTime(DateUtil.now());
        authorityRepository.save(authority);
    }

    public void deleteById(Integer id) {
        authorityRepository.deleteById(id);
    }

    public String getConcatMenuCode(String menuCode) {
        String menuArr = authorityRepository.getConcatMenuCode();
        if (menuCode == null) {
            return menuArr;
        }
        menuArr = menuArr.replace(menuCode+",","");
        return menuArr;
    }
}
