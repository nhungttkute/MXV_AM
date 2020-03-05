/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.am.dto;

import com.newgen.am.model.Commodity;
import java.util.List;

/**
 *
 * @author nhungtt
 */
public class UserCommoditiesDTO {
    private List<Commodity> commodities;

    public List<Commodity> getCommodities() {
        return commodities;
    }

    public void setCommodities(List<Commodity> commodities) {
        this.commodities = commodities;
    }
    
}
