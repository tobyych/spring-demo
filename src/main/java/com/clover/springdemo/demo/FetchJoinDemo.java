package com.clover.springdemo.demo;

import com.clover.springdemo.entity.Course;
import com.clover.springdemo.entity.Instructor;
import com.clover.springdemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FetchJoinDemo {

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

            int theId = 1;

            Query<Instructor> query = session.createQuery("select i from Instructor i "
                                                           + "JOIN FETCH i.courses "
                                                           + "where i.id=:theInstructorId",
                                                           Instructor.class);

            query.setParameter("theInstructorId", theId);

            Instructor tempInstructor = query.getSingleResult();

            System.out.println("Instructor: " + tempInstructor);

            session.getTransaction().commit();

            System.out.printf("Courses: " + tempInstructor.getCourses());
        } catch (Exception e) {
            System.out.println("Failed to get courses!");

            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
