/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.am.model;

/**
 *
 * @author nhungtt
 */
public class Individual {
    private String fullName;
    private String birthday;
    private String identityCard;
    private String idCreatedDate;
    private String idCreatedLocation;
    private String email;
    private String phoneNumber;
    private String address;
    private String scannedIdCard; // Imgage data
    private String scannedSignature; // Image data

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getIdCreatedDate() {
        return idCreatedDate;
    }

    public void setIdCreatedDate(String idCreatedDate) {
        this.idCreatedDate = idCreatedDate;
    }

    public String getIdCreatedLocation() {
        return idCreatedLocation;
    }

    public void setIdCreatedLocation(String idCreatedLocation) {
        this.idCreatedLocation = idCreatedLocation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getScannedIdCard() {
        return scannedIdCard;
    }

    public void setScannedIdCard(String scannedIdCard) {
        this.scannedIdCard = scannedIdCard;
    }

    public String getScannedSignature() {
        return scannedSignature;
    }

    public void setScannedSignature(String scannedSignature) {
        this.scannedSignature = scannedSignature;
    }
    
}
