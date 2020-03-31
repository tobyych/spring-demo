package com.clover.aopdemo.dao;


import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public int addAccount() {
        System.out.println(getClass() + ": DOING SOME STUFF: ADDING ACCOUNT");
        return 0;
    }

    public void doSomething() {
        System.out.println("Doing something....");
    }
}
