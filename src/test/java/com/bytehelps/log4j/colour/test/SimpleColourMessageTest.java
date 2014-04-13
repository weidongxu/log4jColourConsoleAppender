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
public class SimpleColourMessageTest {
    
    private static final Logger logger = Logger.getLogger(SimpleColourMessageTest.class);
    
    @Test
    public void printColourMessageOnConsole(){
       logger.info("print a colour message in blue on console");
    }
    
}
