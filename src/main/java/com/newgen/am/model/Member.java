/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.am.model;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@Table(name = "members")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Member extends AuditModel implements Serializable {
    @Id
    @SequenceGenerator(name = "SEQ_MEM_GEN", sequenceName = "SEQ_MEMBER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MEM_GEN")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String code;
    private String name;
    private String note;
    @Type(type = "jsonb")
    @Column(columnDefinition = "json")
    private Company company;
    @Type(type = "jsonb")
    @Column(columnDefinition = "json")
    private Contact contact;
    @Type(type = "jsonb")
    @Column(columnDefinition = "json")
    private List<UserRole> roles = new ArrayList<>();
    @Type(type = "jsonb")
    @Column(columnDefinition = "json")
    private List<RoleFunction> functions = new ArrayList<>();
    @Type(type = "jsonb")
    @Column(columnDefinition = "json")
    private PositionLimit positionLimit;
    @Type(type = "jsonb")
    @Column(columnDefinition = "json")
    private List<Commodity> comodities = new ArrayList<>();
    @Type(type = "jsonb")
    @Column(columnDefinition = "json")
    private List<MemberUser> users = new ArrayList<>();
    @Type(type = "jsonb")
    @Column(columnDefinition = "json")
    private List<Broker> brokers = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<MemberUser> getUsers() {
        return users;
    }

    public void setUsers(List<MemberUser> users) {
        this.users = users;
    }

    public List<Broker> getBrokers() {
        return brokers;
    }

    public void setBrokers(List<Broker> brokers) {
        this.brokers = brokers;
    }
    
    public List<Commodity> getComodities() {
        return comodities;
    }

    public void setComodities(List<Commodity> comodities) {
        this.comodities = comodities;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public List<RoleFunction> getFunctions() {
        return functions;
    }

    public void setFunctions(List<RoleFunction> functions) {
        this.functions = functions;
    }

    public PositionLimit getPositionLimit() {
        return positionLimit;
    }

    public void setPositionLimit(PositionLimit positionLimit) {
        this.positionLimit = positionLimit;
    }
    
}
