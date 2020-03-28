package com.clover.springdemo.demo;

import com.clover.springdemo.entity.Instructor;
import com.clover.springdemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDemo {

    public static void main (String[] args) {

        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);


            if (tempInstructor != null) {
                System.out.println("Deleting instructor: " + tempInstructor);
                session.delete(tempInstructor);
            }

            session.getTransaction().commit();

            System.out.println("Deleted successfully.");

        } catch (Exception e) {
            System.out.println("Failed to delete student!");

            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
