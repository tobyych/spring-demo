package com.clover.springdemo.demo;

import com.clover.springdemo.entity.Course;
import com.clover.springdemo.entity.Instructor;
import com.clover.springdemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorCoursesDemo {

    public static void main (String[] args) {

        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
//            Instructor tempInstructor = new Instructor("Toby", "Yue", "toby.yue@demo.com");
//
//            InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com/toby.yue", "gaming");
//
//            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
            Course tempCourse2 = new Course("The Pinball Runner");

            tempInstructor.add(tempCourse1);
            tempInstructor.add(tempCourse2);

            session.save(tempCourse1);
            session.save(tempCourse2);

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
