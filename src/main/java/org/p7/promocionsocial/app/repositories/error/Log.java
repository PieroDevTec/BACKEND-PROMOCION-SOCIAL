package org.p7.promocionsocial.app.repositories.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
    private static Logger log = LoggerFactory.getLogger(Log.class);

    public static void logMessage(Exception e){
        log.warn(e.getClass()+"::"+e.getMessage());
    }
}
