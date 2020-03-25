package com.clover.springdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentsDemo {

    public static void main (String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;

            session.beginTransaction();

            System.out.println("Updating emails for all students...");
            session.createQuery("update Student set email='foo@bar.com'")
                   .executeUpdate();

            session.getTransaction().commit();
            System.out.println("Saved successfully.");

        } catch (Exception e) {
            System.out.println("Failed to save student!");

            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
