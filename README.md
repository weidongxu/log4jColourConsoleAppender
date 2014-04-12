log4jColourConsoleAppender
==========================

a small log4j utility class to enable console to print message in colour during debug process

how to use

1 use command: maven install and install artifact into local maven repo

2 use newly-built artifact in pom.xml of your current maven project as follows

         <dependency>
             <groupId>com.bytehelps</groupId>
             <artifactId>log4jColourConsoleAppender</artifactId>
             <version>1.0-SNAPSHOT</version>
        </dependency>

3 config log4j.xml as follows

    <appender name="console-color" class="org.apache.log4j.colour.AnsiColourConsoleAppender">
        <param name="attribute" value="bright"/>
        <param name="fontColor" value="red"/>
        <param name="backgroundColor" value="NONE"/>
        <param name="Target" value="System.out" />
        <layout class="org.apache.log4j.PatternLayout">
            <param name="ConversionPattern" value="%-5p %c{1} - %m%n" />
           

        </layout>
    </appender>
    
    
    <logger name="com.bytehelps.log4j.colour" additivity="false">
        <level value="warn" />
        <appender-ref ref="console-color" />
    </logger>
    
4 current implementation supports  ansi based console (tested on mac os terminal, eclipse, netbean, idea IDE console)
  note that ansi console plugin should be installed in IDE tools in order to work properly
  
