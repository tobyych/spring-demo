package com.clover.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main (String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPDemoConfig.class);

        AccountDAO dao = context.getBean("accountDAO", AccountDAO.class);

        dao.addAccount();

        context.close();
    }
}
