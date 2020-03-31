package com.clover.aopdemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTest {

    public static void main (String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&useUnicode=true&characterEncoding=UTF-8";

        String user = "admin";
        String password = "admin";

        try {
            System.out.println("Connecting to to database: " + jdbcUrl);

            Connection conn = DriverManager.getConnection(jdbcUrl, user, password);

            if (conn != null) {
                System.out.println("Connection is successful");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
