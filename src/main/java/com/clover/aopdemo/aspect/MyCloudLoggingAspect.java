package com.clover.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class MyCloudLoggingAspect {
    @Before("com.clover.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void logToCloud() {
        System.out.println("\n=====> Logging to cloud");
    }
}
