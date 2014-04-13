/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bytehelps.log4j.colour.test;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 *
 * @author weidong
 */
public class AnotherColourMessageTest {
    
    private static final Logger logger = Logger.getLogger(AnotherColourMessageTest.class);
    
    @Test
    public void printAnotherColourMessage(){
        logger.warn("print warning message in red-background on console");
    }
    
}
