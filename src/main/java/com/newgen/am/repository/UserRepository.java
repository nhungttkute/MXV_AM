package com.newgen.am.repository;

import com.newgen.am.model.LoginAdminUser;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<LoginAdminUser, Long> {

  boolean existsByUsername(String username);

  LoginAdminUser findByUsername(String username);

  @Transactional
  void deleteByUsername(String username);

}
