/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.am.common;

import javax.annotation.ManagedBean;
import org.springframework.web.context.annotation.RequestScope;

/**
 *
 * @author nhungtt
 */
@ManagedBean
@RequestScope
public class RequestContext {
    private Object requestBody;

    public Object getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(Object requestBody) {
        this.requestBody = requestBody;
    }
}
