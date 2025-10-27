package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class loggerUtility {
    private loggerUtility() {
    }

    public static Logger getLogger(Class<?> clazz) {
        Logger logger = LogManager.getLogger(clazz);
        if(logger == null) {
            logger = LogManager.getLogger(clazz);
        }
        return logger;
    }
    
}
