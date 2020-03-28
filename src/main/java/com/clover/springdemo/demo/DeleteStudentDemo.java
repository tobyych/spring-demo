package com.clover.springdemo.demo;

import com.clover.springdemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

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

            session.delete(myStudent);

            // session.createQuery("delete from Student where id=1").executeUpdate();

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
