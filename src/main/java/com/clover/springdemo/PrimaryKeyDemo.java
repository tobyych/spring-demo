package com.clover.springdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main (String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student tempStudent1 = new Student("Gento", "Yeung", "gento.yeung@domain.com");
            Student tempStudent2 = new Student("Charlotte", "Lam", "charlotte.lam@domain.com");
            Student tempStudent3 = new Student("Ricky", "Shiu", "ricky.shiu@domain.com");


            session.beginTransaction();

            System.out.println("Saving the students");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            session.getTransaction().commit();

            System.out.println("Saved successfully.");

            System.out.println("Closing session...");

            session.close();

            System.out.println("Closed session.");

        } catch (Exception e) {
            System.out.println("Failed to save student!");

            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
