package com.example.JobSpringRestApplication.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private final Logger _logger = LoggerFactory.getLogger(LoggingAspect.class);

    // return type class-name.method-name(args)
    @Before("execution(* com.example.JobSpringRestApplication.service.JobService.*(..)) || execution(* com.example.JobSpringRestApplication.controller.JobController.*(..))")
    public void logMethodBeforeCall(JoinPoint joinpoint){
        _logger.info("Method Called Method Name :: " + joinpoint.getSignature().getName());
    }

    @After("execution(* com.example.JobSpringRestApplication.service.JobService.*(..)) || execution(* com.example.JobSpringRestApplication.controller.JobController.*(..))")
    public void logMethodAfterCall(JoinPoint joinpoint){
        _logger.info("Method Called Method Name :: " + joinpoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.example.JobSpringRestApplication.service.JobService.*(..)) || execution(* com.example.JobSpringRestApplication.controller.JobController.*(..))")
    public void logMethodAfterSuccessCall(JoinPoint joinpoint){
        _logger.info("Method Called with success method name :: " + joinpoint.getSignature().getName());
    }

    @AfterThrowing("execution(* com.example.JobSpringRestApplication.service.JobService.*(..)) || execution(* com.example.JobSpringRestApplication.controller.JobController.*(..))")
    public void logMethodAfterErrorCall(JoinPoint joinpoint){
        _logger.info("Method Called with issue method name :: " + joinpoint.getSignature().getName());
    }
}
