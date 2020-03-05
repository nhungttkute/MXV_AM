/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.am.model;

import java.util.Date;

/**
 *
 * @author nhungtt
 */
public class DeptUser extends BaseUser {
    private Integer logonCounts;
    private Date logonTime;

    public Integer getLogonCounts() {
        return logonCounts;
    }

    public void setLogonCounts(Integer logonCounts) {
        this.logonCounts = logonCounts;
    }

    public Date getLogonTime() {
        return logonTime;
    }

    public void setLogonTime(Date logonTime) {
        this.logonTime = logonTime;
    }
}
