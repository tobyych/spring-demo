package com.clover.springdemo.demo;

import com.clover.springdemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main (String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student tempStudent = new Student("Gento", "Yeung", "gento.yeung@domain.com");

            session.beginTransaction();

            System.out.println("Saving the students");
            session.save(tempStudent);

            session.getTransaction().commit();

            System.out.println("Saved successfully.");
            System.out.println("Saved id: " + tempStudent.getId());

            System.out.println("Closing session...");
            session.close();

            session = factory.getCurrentSession();

            session.beginTransaction();

            System.out.println("Getting a student with id: " + tempStudent.getId());
            Student myStudent = session.get(Student.class, tempStudent.getId());

            if (myStudent != null) {
                System.out.println("The retrieved student: " + myStudent);
            } else {
                System.out.println("Student not found with id: " + tempStudent.getId());
            }

            session.getTransaction().commit();

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
