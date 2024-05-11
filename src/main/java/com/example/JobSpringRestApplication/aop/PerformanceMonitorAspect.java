package com.example.JobSpringRestApplication.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {
    private final Logger _logger = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.example.JobSpringRestApplication.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        _logger.info("Method " + joinPoint.getSignature().getName() + " took " + (endTime - startTime) + "ms to execute.");
        return result;
    }
}
