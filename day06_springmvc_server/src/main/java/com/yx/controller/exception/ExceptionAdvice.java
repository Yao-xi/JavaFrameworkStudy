package com.yx.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@ControllerAdvice
public class ExceptionAdvice {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);
    
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public String exception(Exception e) {
        LOGGER.error("发生未知异常", e);
        return "Exception!";
    }
}
