/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.am.model;

import java.io.Serializable;

/**
 *
 * @author nhungtt
 */
public class Location implements Serializable {
    private String country;
 
    private String city;
 
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) { 
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location{" +
                "country='" + country + "'" +
                ", city='" + city + "'}";
    }
}
