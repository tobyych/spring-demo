package com.clover.springdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main (String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;

            session.beginTransaction();

            System.out.println("Getting the student with student id 1");
            Student myStudent = session.get(Student.class, studentId);

            // Update the information

            System.out.println("Before: " + myStudent);

            myStudent.setFirstName("Fat");
            myStudent.setLastName("Lam");

            System.out.println("After: " + myStudent);

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
