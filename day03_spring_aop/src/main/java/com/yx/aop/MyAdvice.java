package com.yx.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 增强类 切面类
 */
@Component
// @Aspect
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
            // 获取参数数组
            Object[] args = pjp.getArgs();
            // 执行原方法
            ret = pjp.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return ret;
    }
}
