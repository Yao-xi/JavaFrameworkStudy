package com.yx.controller.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class GenderConstraintValidator implements ConstraintValidator<Gender, String> {
    
    /**
     * 变量，用来存储Gender中性别属性的值
     */
    private int[] options;
    
    /**
     * 初始化方法
     *
     * @param constraintAnnotation
     */
    @Override
    public void initialize(Gender constraintAnnotation) {
        // 把使用注解时指定的options属性的值，获取过来，并存储在options变量中
        options = constraintAnnotation.options();
    }
    
    /**
     * 校验规则
     *
     * @param value
     *     被校验的值
     * @param constraintValidatorContext
     *
     * @return 校验是否通过
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        //判断被校验内容是否包含在"性别选项"中，如果包含就返回true，校验通过
        return Arrays.asList(options).contains(value);
    }
}
