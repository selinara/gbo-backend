package com.chl.gbo.cental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.chl.gbo.cental.domain.User;

/**
 * @Auther: BoYanG
 * @Describe
 */
public interface UserRepository extends JpaRepository<User, Integer> ,JpaSpecificationExecutor<User> {

    @Query(value = "select a.*,null as roleNames,null as roleIds from tb_user a where a.loginAccount=?1", nativeQuery = true)
    List<User> findByLoginAccount(String loginAccount);

    /**
     * 查询所有用户的信息以及权限
     * @return
     */
    @Query(value = "SELECT t.userId,t.loginAccount,t.loginPass,t.userName,t.userHead,t.userPhone,t.userEmail,t.userSex," +
            "t.userBirthday,t.registerTime,t.departmentKey,GROUP_CONCAT(t.roleKey) AS roleNames,GROUP_CONCAT(t.roleId) AS roleIds " +
            "FROM (SELECT a.*,c.roleKey, c.roleId  FROM tb_user a LEFT JOIN tb_user_role b ON a.userId = b.userId " +
            "LEFT JOIN tb_role c ON b.roleId = c.roleId ) AS t GROUP BY loginAccount,loginPass", nativeQuery = true)
    List<User> findAllUsersAndAuthority();
}
