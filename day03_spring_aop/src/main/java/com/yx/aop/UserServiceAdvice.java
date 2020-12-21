package com.yx.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.stereotype.Component;

@Component
public class UserServiceAdvice {
    
    public Object around(ProceedingJoinPoint pjp) {
        Object ret = null;
        try {
            Signature signature = pjp.getSignature();
            long start = System.currentTimeMillis();
            // 执行原方法
            ret = pjp.proceed();
            long end = System.currentTimeMillis();
            System.out.println(signature.getDeclaringType() + "::" + signature.getName()
                               + " run: " + (end - start));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return ret;
    }
}
