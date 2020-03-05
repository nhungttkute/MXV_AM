/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.am.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author nhungtt
 */
@Entity
@Table(name = "login_admin_users")
public class LoginAdminUser extends AuditModel implements Serializable {
    @Id
    @SequenceGenerator(name = "SEQ_ADM_GEN", sequenceName = "SEQ_ADM_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ADM_GEN")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    @JsonIgnore
    private String password;
    @Column(columnDefinition = "Boolean default true", nullable = false)
    private Boolean checkPin = true;
    @Column(nullable = false)
    private String pin;
    @Column(name = "access_token")
    private String accessToken;
    @Column(name = "token_expiration")
    private Long tokenExpiration;
    @Column(columnDefinition = "Boolean default false", nullable = false)
    private Boolean logined = false;
    @Column(name = "department_id")
    private Integer departmentId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "member_id")
    private Integer memberId;
    @Column(name = "member_user_id")
    private Integer memberUserId;
    @Column(name = "broker_id")
    private Integer brokerId;
    @Column(name = "collaborator_id")
    private Integer collaboratorId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getCheckPin() {
        return checkPin;
    }

    public void setCheckPin(Boolean checkPin) {
        this.checkPin = checkPin;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getTokenExpiration() {
        return tokenExpiration;
    }

    public void setTokenExpiration(Long tokenExpiration) {
        this.tokenExpiration = tokenExpiration;
    }

    public Boolean getLogined() {
        return logined;
    }

    public void setLogined(Boolean logined) {
        this.logined = logined;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getMemberUserId() {
        return memberUserId;
    }

    public void setMemberUserId(Integer memberUserId) {
        this.memberUserId = memberUserId;
    }

    public Integer getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Integer brokerId) {
        this.brokerId = brokerId;
    }

    public Integer getCollaboratorId() {
        return collaboratorId;
    }

    public void setCollaboratorId(Integer collaboratorId) {
        this.collaboratorId = collaboratorId;
    }
  
}
