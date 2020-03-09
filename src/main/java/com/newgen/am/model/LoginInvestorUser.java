/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.am.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author nhungtt
 */
@Entity
@Table(name = "login_investor_users")
public class LoginInvestorUser extends AuditModel implements Serializable {

    @Id
    @SequenceGenerator(name = "SEQ_INV_GEN", sequenceName = "SEQ_INV_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_INV_GEN")
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
    @Column(name = "member_id")
    private Integer memberId;
    @Column(name = "broker_id")
    private Integer brokerId;
    @Column(name = "collaborator_id")
    private Integer collaboratorId;
    @Column(name = "investor_id")
    private Integer investorId;
    @Column(name = "investor_user_id")
    private Integer investorUserId;
    @Column(length = 100000)
    private String layout;
    private String language;
    private String theme;
    private Integer fontSize;
    @Type(type = "jsonb")
    @Column(columnDefinition = "json")
    private List<WatchList> watchlists = new ArrayList<>();

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

    public Integer getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Integer investorId) {
        this.investorId = investorId;
    }

    public Integer getInvestorUserId() {
        return investorUserId;
    }

    public void setInvestorUserId(Integer investorUserId) {
        this.investorUserId = investorUserId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
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

    public List<WatchList> getWatchlists() {
        return watchlists;
    }

    public void setWatchlists(List<WatchList> watchlists) {
        this.watchlists = watchlists;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }
}
