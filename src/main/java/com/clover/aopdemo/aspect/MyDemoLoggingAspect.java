package com.clover.aopdemo.aspect;

import com.clover.aopdemo.Account;
import org.apache.jasper.compiler.JspUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

    Logger logger = Logger.getLogger(getClass().getName());

    @Before("com.clover.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        logger.info("\n=====> Demo logging");

        MethodSignature signature = (MethodSignature) theJoinPoint.getSignature();

        logger.info("Method: " + signature);

        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg : args) {
            if (tempArg instanceof Account) {
                logger.info(tempArg.toString());
            }
        }
    }

    @AfterReturning(
        pointcut="execution(* com.clover.aopdemo.dao.AccountDAO.findAccounts(..))",
        returning="results"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> results) {
        String method = joinPoint.getSignature().toShortString();

        logger.info("\n==========>>>> Executing @AfterReturning on method: " + method);
        logger.info("\n==========>>>> result is: " + results);

        if (!results.isEmpty()) {
            for (Account tempAccount : results) {
                tempAccount.setName(tempAccount.getName().toUpperCase());
            }
        }

        logger.info("\n==========>>>> Executing @AfterReturning on method: " + method);
        logger.info("\n==========>>>> result is: " + results);
    }

    @AfterThrowing(
        pointcut="execution(* com.clover.aopdemo.dao.AccountDAO.findWrongAccounts(..))",
        throwing="exception"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
        String method = joinPoint.getSignature().toShortString();

        logger.info("\n==========>>>> The exception thrown is: " + exception);

        logger.info("I can do more things within this block of code");
    }

    @After("execution(* com.clover.aopdemo.dao.AccountDAO.findWrongAccounts(..))")
    public void afterFindAccountsAdvice(JoinPoint joinPoint) {
        logger.info("Will print this line no matter the method runs successfully or not");
    }
}
