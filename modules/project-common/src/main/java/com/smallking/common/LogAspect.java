package com.smallking.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private final static Logger logger = Logger.getLogger(LogAspect.class);
    @Pointcut("@annotation(com.smallking.annotation.Log)")
    public void pointcut() {}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {

        Object result = null;
        long startTime = System.currentTimeMillis();

        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();

        long proceedTime = endTime - startTime;
        logger.info("执行时间" + proceedTime);
        return result;
    }
}
