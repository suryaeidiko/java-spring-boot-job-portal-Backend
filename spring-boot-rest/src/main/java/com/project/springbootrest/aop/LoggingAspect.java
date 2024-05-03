package com.project.springbootrest.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

//    returnType class-name.method-name(args)
//    @Before("execution(* com.project.springbootrest.service.JobService.*(..))")
//    public void logMethodCall() {
//        LOGGER.info("method call...");
//    }

    @Before("execution(* com.project.springbootrest.service.JobService.allJobs(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("method call..." + jp.getSignature().getName());
    }

    @After("execution(* com.project.springbootrest.service.JobService.allJobs(..))")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info("method executed..." + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.project.springbootrest.service.JobService.allJobs(..))")
    public void logMethodException(JoinPoint jp) {
        LOGGER.info("method with issue..." + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.project.springbootrest.service.JobService.allJobs(..))")
    public void logMethodSuccess(JoinPoint jp) {
        LOGGER.info("method Executed Successfully..." + jp.getSignature().getName());
    }

}
