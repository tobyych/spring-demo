package com.clover.springdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(-1)
public class TimeProfilingAspect {

    private static Logger logger = Logger.getLogger(TimeProfilingAspect.class.getName());

    @Around("com.clover.aopdemo.aspect.AopExpressions.forServices()")
        public Object timeProfiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String method = proceedingJoinPoint.getSignature().toShortString();

        long start = System.currentTimeMillis();

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            logger.warning(e.getMessage());

            result = "Major accident! But no worries, your privateAOP helicopter is on the way!";
//            throw e;
        }

        long end = System.currentTimeMillis();

        long duration = end - start;

        logger.info("The method " + method + " took: " + duration  / 1000.0 + " seconds.");

        return result;
    }
}
