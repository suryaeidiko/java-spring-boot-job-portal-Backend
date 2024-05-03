package com.project.springbootrest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitoringAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitoringAspect.class);

    @Around("execution(* com.project.springbootrest.service.JobService.*(..))")
    public Object moniterTime(ProceedingJoinPoint jp) throws Throwable {

        long StartTime = System.currentTimeMillis();

        Object obj = jp.proceed();

        long EndTime = System.currentTimeMillis();

        LOGGER.info("Time taken for methos "+ jp.getSignature().getName() + " "+(EndTime - StartTime) + " ms");
        return  obj;

    }

}
