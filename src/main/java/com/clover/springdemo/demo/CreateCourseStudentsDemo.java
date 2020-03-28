package com.clover.springdemo.demo;

import com.clover.springdemo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseStudentsDemo {

    public static void main (String[] args) {

        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .addAnnotatedClass(Review.class)
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

//            Course tempCourse = new Course("Pacman - How To Score One Million Points");
//
//            session.save(tempCourse);
//
//            Student tempStudent1 = new Student("Toby", "Yue", "toby.yue@abc.com");
//            Student tempStudent2 = new Student("Charlotte", "Lam", "charlotte.lam@abc.com");
//
//            tempCourse.addStudent(tempStudent1);
//            tempCourse.addStudent(tempStudent2);
//
//            System.out.println("Saving students..");
//
//            session.save(tempStudent1);
//            session.save(tempStudent2);

            int theId = 4;

            Student theStudent = session.get(Student.class, theId);

            Course tempCourse1 = new Course("Atari");
            Course tempCourse2 = new Course("Rubik's cube");

            tempCourse1.addStudent(theStudent);
            tempCourse2.addStudent(theStudent);

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
