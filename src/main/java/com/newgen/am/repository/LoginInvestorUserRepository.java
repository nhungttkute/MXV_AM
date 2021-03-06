/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.am.repository;

import com.newgen.am.model.LoginInvestorUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nhungtt
 */
public interface LoginInvestorUserRepository extends JpaRepository<LoginInvestorUser, Long> {

    boolean existsByUsername(String username);

    LoginInvestorUser findByUsername(String username);
}
