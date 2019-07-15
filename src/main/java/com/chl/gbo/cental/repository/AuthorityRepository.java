package com.chl.gbo.cental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chl.gbo.cental.domain.Authority;

/**
 * @Auther: BoYanG
 * @Describe 权限
 */
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    List<Authority> findByDataUrl(String dataUrl);

}
