package com.chl.gbo.cental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chl.gbo.cental.domain.User;

/**
 * @Auther: BoYanG
 * @Describe
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByLoginAccount(String loginAccount);
}
