package com.clover.springdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReadStudentsDemo {

    public static void main (String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Student> students = session.createQuery("from Student s where s.lastName='Yeung' or s.firstName='Charlotte'")
                                            .getResultList();

            session.getTransaction().commit();

            session.close();

            displayStudents(students);

        } catch (Exception e) {
            System.out.println("Failed to get students!");

            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
