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
public class BrokerUser extends MemberUser {
    private String identityCard;
    private String idCreatedDate;
    private String idCreatedLocation;
    private String address;
    private String scannedIdCard; //image data
    private String scannedSignature; //image data

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
