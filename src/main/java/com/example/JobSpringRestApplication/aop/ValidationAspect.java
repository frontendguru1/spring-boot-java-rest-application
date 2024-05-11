package com.example.JobSpringRestApplication.aop;

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

    @Around("execution(* com.example.JobSpringRestApplication.service.JobService.*(..)) && args(jobId)")
    public Object validateAndUpdate(ProceedingJoinPoint joinPoint, int jobId) throws Throwable {
        if(jobId < 0) {
            LOGGER.info("PostID is negative, updating it");
            jobId = -jobId;
            LOGGER.info("new value " + jobId);
        }
        return joinPoint.proceed(new Object[]{jobId});
    }
}
