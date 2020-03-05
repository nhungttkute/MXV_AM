/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.am.service;

import com.newgen.am.common.AMLogger;
import com.newgen.am.exception.CustomException;
import com.newgen.am.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author nhungtt
 */
public class MemberService {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    
//    public boolean changeInvestorUserPassword(Long userId, String oldPassword, String newPassword, long refId) throws CustomException {
//        String methodName = "changeInvestorUserPassword";
//        try {
//            return loginInvUserRepository.save(user);
//        } catch (Exception e) {
//            AMLogger.logError(className, methodName, refId, e);
//            throw new CustomException("Cannot save the user", HttpStatus.UNPROCESSABLE_ENTITY);
//        }
//    }
}
