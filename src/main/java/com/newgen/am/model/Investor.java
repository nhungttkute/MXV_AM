/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.am.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nhungtt
 */
public class Investor {
    private Integer id;
    private String code;
    private String name;
    private String status;
    private String note;
    private String type;
    private Company company;
    private Individual individual;
    private Contact contact;
    private InvestorAccount account;
    private List<InvestorUser> users = new ArrayList<>();
    private List<UserRole> roles = new ArrayList<>();
    private PositionLimit positionLimit;
    private List<Commodity> commodities = new ArrayList<>();
    private MarginRatioAlert marginRatioAlert;
    private Double marginMultiplier;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Individual getIndividual() {
        return individual;
    }

    public void setIndividual(Individual individual) {
        this.individual = individual;
    }

    public List<InvestorUser> getUsers() {
        return users;
    }

    public void setUsers(List<InvestorUser> users) {
        this.users = users;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public PositionLimit getPositionLimit() {
        return positionLimit;
    }

    public void setPositionLimit(PositionLimit positionLimit) {
        this.positionLimit = positionLimit;
    }

    public MarginRatioAlert getMarginRatioAlert() {
        return marginRatioAlert;
    }

    public void setMarginRatioAlert(MarginRatioAlert marginRatioAlert) {
        this.marginRatioAlert = marginRatioAlert;
    }

    public Double getMarginMultiplier() {
        return marginMultiplier;
    }

    public void setMarginMultiplier(Double marginMultiplier) {
        this.marginMultiplier = marginMultiplier;
    }

    public List<Commodity> getCommodities() {
        return commodities;
    }

    public void setCommodities(List<Commodity> commodities) {
        this.commodities = commodities;
    }

    public InvestorAccount getAccount() {
        return account;
    }

    public void setAccount(InvestorAccount account) {
        this.account = account;
    }
    
}
