package com.chl.gbo.cental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.chl.gbo.cental.domain.Role;

/**
 * @Auther: BoYanG
 * @Describe 自定义sql语句并且开启本地sql
 */
public interface RoleRepository extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role> {

    /**
     * 根据用户名查找该用户所有权限
     * @param username
     * @return
     */
    @Query(value = "SELECT a.* FROM tb_role a LEFT JOIN tb_user_role b ON a.roleId = b.roleId " +
            "LEFT JOIN tb_user c ON b.userId = c.userId WHERE c.loginAccount = ?1", nativeQuery = true)
    List<Role> getRolesByUserName(String username);

    /**
     * 根据菜单编号查出所有角色
     * @param menuCode
     * @return
     */
    @Query(value = "SELECT a.* FROM tb_role a LEFT JOIN tb_role_authority b ON a.roleKey = b.roleKey " +
            "LEFT JOIN tb_authority c ON b.menuCode = c.menuCode WHERE c.menuCode = ?1", nativeQuery = true)
    List<Role> getAuthoritysByMenuCode(String menuCode);

}
