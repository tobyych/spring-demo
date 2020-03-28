package com.clover.springdemo.demo;

import com.clover.springdemo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseStudentsDemo {

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

            int theId = 3;

//            Course course = session.get(Course.class, theId);
            Student student = session.get(Student.class, theId);


            session.delete(student);


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
