package com.bytehelps.log4j.plain.test;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by weidong on 11/04/14.
 */
public class PlainConsoleDemoTest {

    private static final Logger logger = Logger.getLogger(PlainConsoleDemoTest.class);


    @Test
    public void printPlainMessageOnDefaultConsole() throws Exception{

        logger.info("This is an info message on plain console");
        logger.warn("This is a warning message on plain console");
        logger.debug("This is a debug message on plain console");
        logger.error("This is an error message on plain console");

    }
}
