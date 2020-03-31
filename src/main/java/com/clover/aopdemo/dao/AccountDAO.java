package com.clover.aopdemo.dao;

import com.clover.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public void addAccount(Account account, boolean isVip) {
        System.out.println(getClass() + ": DOING SOME STUFF: ADDING ACCOUNT");
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    public List<Account> findAccounts() {
        List<Account> myAccounts = new ArrayList<>();

        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Tom", "Gold");
        Account temp3 = new Account("Mandy", "Platinum");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }

    public List<Account> findWrongAccounts(boolean tripWire) throws Exception {
        if (tripWire) throw new Exception("A strange exception somewhere in the method");

        return null;
    }

}
