package com.clover.springdemo.demo;

import com.clover.springdemo.entity.Course;
import com.clover.springdemo.entity.Instructor;
import com.clover.springdemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorCoursesDemo {

    public static void main (String[] args) {

        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);

            System.out.println(tempCourse);

            session.delete(tempCourse);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Failed to get courses!");

            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
