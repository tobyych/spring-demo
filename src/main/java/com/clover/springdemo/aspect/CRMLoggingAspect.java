package com.clover.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(0)
public class CRMLoggingAspect {

    Logger logger = Logger.getLogger(getClass().getName());

    @Before("com.clover.springdemo.aspect.AopExpressions.forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();

        logger.info("=====>>> in @Before: calling method: " + method);

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            logger.info("=====>>> argument: " + arg);
        }
    }

    @AfterReturning(
        pointcut="com.clover.springdemo.aspect.AopExpressions.forAppFlow()",
        returning="result"
    )
    public void before(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();

        logger.info("=====>>> in @AfterReturning: from method " + method);

        logger.info("=====>>> result: " + result);
    }
}
