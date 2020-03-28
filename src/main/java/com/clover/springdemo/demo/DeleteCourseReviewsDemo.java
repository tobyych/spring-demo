package com.clover.springdemo.demo;

import com.clover.springdemo.entity.Course;
import com.clover.springdemo.entity.Instructor;
import com.clover.springdemo.entity.InstructorDetail;
import com.clover.springdemo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseReviewsDemo {

    public static void main (String[] args) {

        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .addAnnotatedClass(Review.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 10;

            Course theCourse = session.get(Course.class, theId);

            System.out.println("Course: " + theCourse);
            System.out.println("Reviews: " + theCourse.getReviews());

            session.delete(theCourse);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Failed to save student!");

            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
