/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.am.common;

import org.slf4j.Logger;

/**
 *
 * @author nhungtt
 */
public class BaseLogger {
    protected Logger logger;  // base abstract class has a Log object.

    public BaseLogger(Logger logger) {   // parameterized constructor for logger, to be used by the derived class.
        this.logger = logger;
    }
    
    public void logMessage(long refId, String message) {
        logger.info("REF=" + refId + ", MSG=" + message);
    }

    public void logError(long refId, String message, Throwable ex) {
        logger.error("REF=" + refId + ", MSG=" + message, ex);
    }
}
