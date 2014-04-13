package com.bytehelps.log4j.colour.test;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by weidong on 7/04/14.
 */
public class AnsiColourConsoleAppenderTest {


    private static final Logger logger = Logger.getLogger(AnsiColourConsoleAppenderTest.class);

    @Test
    public void testColorMessageOnConsole() throws Exception {

        logger.info("This is an info message");
        logger.warn("This is a warning message");
        logger.debug("This is a debug message");
        logger.error("This is an error message");
    }


}
