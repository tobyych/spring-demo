package com.clover.springdemo.demo;

import com.clover.springdemo.entity.Course;
import com.clover.springdemo.entity.Instructor;
import com.clover.springdemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetInstructorCoursesDemo {

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
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println(tempInstructor);

            List<Course> courses = tempInstructor.getCourses();

            for (Course course : courses) {
                System.out.println(course);
            }

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
