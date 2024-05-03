package com.project.springbootrest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.project.springbootrest.service.JobService.getJob(..))&& args(postId)")
    public Object validateAndUpdate (ProceedingJoinPoint jp,int postId) throws Throwable {

        if(postId < 0) {
            LOGGER.info("postId is negative, updating...");
            postId = -postId;
            LOGGER.info("postId is updated " + postId);
        }

        Object obj = jp.proceed(new Object[]{postId});

        return obj;
    }

}
