package com.yx.controller.interceptor;

import com.yx.controller.result.Result;
import com.yx.controller.result.ResultFlag;
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
    
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result runtimeExceptionAdvice(Exception e) {
        LOGGER.error("运行时异常", e);
        return new Result(ResultFlag.ERR, null, e.getMessage());
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exceptionAdvice(Exception e) {
        LOGGER.error("未知异常", e);
        return new Result(ResultFlag.ERR, null, e.getMessage());
    }
}
