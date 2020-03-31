package com.clover.aopdemo;

import com.clover.aopdemo.dao.AccountDAO;
import com.clover.aopdemo.dao.MembershipDAO;
import com.clover.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class MainApp {
    
    private static Logger logger = Logger.getLogger(MainApp.class.getName());

    public static void main (String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPDemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        Account account = new Account();

        accountDAO.addAccount(account, false);

        logger.info("\nLet's call the method again!\n");

        accountDAO.addAccount(account,false);

        logger.info("\nLet's call the method from another dao!\n");

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        membershipDAO.addAccount();

        logger.info("\nLet's call another method from the same dao!\n");

        membershipDAO.doSomething();

        logger.info("\nLet's call some getters and setters!\n");

        accountDAO.getName();
        accountDAO.getServiceCode();

        accountDAO.setName("Toby");
        accountDAO.setServiceCode("No idea");

        logger.info("\n------------------------\n");

        List<Account> theAccounts = accountDAO.findAccounts();

        try {
            boolean tripWire = false;
            accountDAO.findWrongAccounts(tripWire);
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.info("\n================================\n");

        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);


        boolean tripWire = true;
        String myFortune = fortuneService.getFortune(tripWire);
        logger.info(myFortune);

        context.close();
    }
}
