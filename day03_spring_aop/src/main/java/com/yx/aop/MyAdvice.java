package com.yx.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 增强类 切面类
 */
@Component
@Aspect
public class MyAdvice {
    
    @Pointcut("execution(* com.yx.service..*Service.*(..))")
    public void pt() { }
    
    /**
     * 前置通知
     */
    @Before("pt()")
    public void before() {
        System.out.println("before 增强 ...");
    }
    
    /**
     * 环绕通知
     */
    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) {
        Object ret = null;
        try {
            Object[] args = pjp.getArgs();
            System.out.println(Arrays.toString(args));
            ret = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return ret;
    }
}
