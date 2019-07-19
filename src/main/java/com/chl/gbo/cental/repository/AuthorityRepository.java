package com.chl.gbo.cental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.chl.gbo.cental.domain.Authority;

/**
 * @Auther: BoYanG
 * @Describe 权限
 */
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    List<Authority> findByDataUrl(String dataUrl);

    @Modifying
    @Query(value = "delete from tb_role_authority where menuCode =?1", nativeQuery = true)
    void deleteRoleAuth(String code);

    void deleteByMenuCode(String code);

    @Query(value = "SELECT CONCAT(GROUP_CONCAT(menuCode), ',') AS str FROM tb_authority", nativeQuery = true)
    String getConcatMenuCode();
}
