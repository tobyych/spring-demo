package com.clover.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.clover.aopdemo.dao.*.*(..))")
    public void forAddAccount() {}

    @Pointcut("execution(* com.clover.aopdemo.dao.*.get*(..))")
    public void forGetters() {}

    @Pointcut("execution(* com.clover.aopdemo.dao.*.set*(..))")
    public void forSetters() {}

    @Pointcut("forAddAccount() && !(forGetters() || forSetters())")
    public void forDaoPackageNoGetterSetter() {}

    @Pointcut("execution(* com.clover.aopdemo.service.*.*(..))")
    public void forServices() {}
}
