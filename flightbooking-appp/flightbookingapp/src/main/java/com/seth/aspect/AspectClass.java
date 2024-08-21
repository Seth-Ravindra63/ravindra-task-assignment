package com.seth.aspect;

import org.slf4j.LoggerFactory;

public class AspectClass {


    private final org.slf4j.Logger logger = LoggerFactory.getLogger(AspectClass.class);

    public void adviceForAll()
    {
        logger.info("Advice Given.........");
    }

}
