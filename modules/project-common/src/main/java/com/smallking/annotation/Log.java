package com.smallking.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: project-common
 * @description: 日志记录注解
 * @author: smallking
 * @create: 2019-07-28 23:21
 **/
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Log {

    String value() default "";
}
