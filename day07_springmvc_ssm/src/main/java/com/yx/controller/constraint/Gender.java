package com.yx.controller.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验性别：
 * 只能是 0, 1
 * 或者在使用@Gender时指定范围。 如：@Gender(options={"male","female"})
 * <p>
 * &#64;Constraint: 用来指定该注解的校验逻辑类
 * <p>
 * &#64;Target: 该处限定只能在字段上使用
 * <p>
 * &#64;Retention: 表示注解在运行时仍然可以正常使用
 */
@Constraint(validatedBy = GenderConstraintValidator.class)
@Target(value = {ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Gender {
    /**
     * 拦截的字符串
     */
    int[] options() default {0, 1};
    
    /**
     * 验证不通过时的错误提示信息
     */
    String message() default "性别有误";
    
    /**
     * 所属规则组
     */
    Class<?>[] groups() default {};
    
    /**
     * 固定内容，不能修改
     */
    Class<? extends Payload>[] payload() default {};
}
