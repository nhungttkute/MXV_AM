/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.am.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author nhungtt
 */
@JsonInclude(Include.NON_DEFAULT)
public class PositionLimit {
    private Integer positionLimit;
    private Integer orderLimit;

    public Integer getPositionLimit() {
        return positionLimit;
    }

    public void setPositionLimit(Integer positionLimit) {
        this.positionLimit = positionLimit;
    }

    public Integer getOrderLimit() {
        return orderLimit;
    }

    public void setOrderLimit(Integer orderLimit) {
        this.orderLimit = orderLimit;
    }

}
