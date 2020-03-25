package com.clover.springdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

    public static void main (String[] args) {

        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 3;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

            if (tempInstructorDetail != null) {
                System.out.println("Deleting instructor detail: " + tempInstructorDetail);
                tempInstructorDetail.getInstructor().setInstructorDetail(null);
                session.delete(tempInstructorDetail);
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
