package com.clover.springdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.clover.springdemo.controller.*.*(..))")
    public void forControllers() {}

    @Pointcut("execution(* com.clover.springdemo.service.*.*(..))")
    public void forServices() {}

    @Pointcut("execution(* com.clover.springdemo.dao.*.*(..))")
    public void forDaos() {}

    @Pointcut("forControllers() || forServices() || forDaos()")
    public void forAppFlow() {}
}
