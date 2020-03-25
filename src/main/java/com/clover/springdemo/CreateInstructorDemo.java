package com.clover.springdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main (String[] args) {

        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
//            Instructor tempInstructor = new Instructor("Toby", "Yue", "toby.yue@demo.com");
//
//            InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com/toby.yue", "gaming");
//
//            tempInstructor.setInstructorDetail(tempInstructorDetail);
//
//            session.beginTransaction();
//
//            session.save(tempInstructor);
//
//            session.getTransaction().commit();
//
//            session = factory.getCurrentSession();

            session.beginTransaction();

            int theId = 87654;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

            System.out.println(tempInstructorDetail);

            System.out.printf("Associated instructor:");

            System.out.println(tempInstructorDetail.getInstructor());

            session.getTransaction().commit();

            System.out.println("Saved successfully.");
        } catch (Exception e) {
            System.out.println("Failed to save student!");

            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
