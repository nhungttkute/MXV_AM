/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.am.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author nhungtt
 */
@Entity
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column
    @JsonIgnore
    private String password;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column
    private String email;
    @Column
    private String accountNo;
    @Column(name = "available_balance")
    private Long availableBalance;
    @Column(name = "position_limit")
    private Long positionLimit;
    @Column(name = "order_limit")
    private Long orderLimit;
    @Column(name = "deposit_ratio")
    private Long depositRatio;
    @Column(name = "access_token")
    private String accessToken;
    @Column(name = "token_expiration")
    private Long tokenExpiration;
    @Type( type = "string-array" )
    @Column(
        name = "contracts",
        columnDefinition = "text[]"
    )
    private String[] contracts;
    @Type(type = "jsonb")
    @Column(columnDefinition = "json")
    private List<Commodity> commodities = new ArrayList<Commodity>();
    @Column(columnDefinition = "Boolean default false", nullable = false)
    private Boolean logined = false;
    
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Long getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Long availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Long getPositionLimit() {
        return positionLimit;
    }

    public void setPositionLimit(Long positionLimit) {
        this.positionLimit = positionLimit;
    }

    public Long getOrderLimit() {
        return orderLimit;
    }

    public void setOrderLimit(Long orderLimit) {
        this.orderLimit = orderLimit;
    }

    public Long getDepositRatio() {
        return depositRatio;
    }

    public void setDepositRatio(Long depositRatio) {
        this.depositRatio = depositRatio;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String[] getContracts() {
        return contracts;
    }

    public void setContracts(String[] contracts) {
        this.contracts = contracts;
    }

    public List<Commodity> getCommodities() {
        return commodities;
    }

    public void setCommodities(List<Commodity> commodities) {
        this.commodities = commodities;
    }
    
    public Long getTokenExpiration() {
        return tokenExpiration;
    }

    public void setTokenExpiration(Long tokenExpiration) {
        this.tokenExpiration = tokenExpiration;
    }

    public Boolean isLogined() {
        return logined;
    }

    public void setLogined(Boolean logined) {
        this.logined = logined;
    }
    
}
