package com.clover.springdemo.demo;

import com.clover.springdemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main (String[] args) {

        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student tempStudent = new Student("Toby", "Yue", "toby.yue@domain.com");

            session.beginTransaction();

            System.out.println("Saving the student: " + tempStudent);
            session.save(tempStudent);

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
