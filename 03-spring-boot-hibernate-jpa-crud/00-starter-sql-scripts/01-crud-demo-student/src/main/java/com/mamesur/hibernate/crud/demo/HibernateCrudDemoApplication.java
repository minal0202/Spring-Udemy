package com.mamesur.hibernate.crud.demo;

import com.mamesur.hibernate.crud.demo.dao.StudentDAO;
import com.mamesur.hibernate.crud.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateCrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateCrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
            createMultipleStudents(studentDAO);
//            retrieveStudent(studentDAO, 1);
//            findAllStudents(studentDAO);
//            queryStudentByLastName(studentDAO,"Doe");
//            updateStudentName(studentDAO);
//            deleteStudent(studentDAO);
//            deleteAllStudent(studentDAO);
        };

    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        System.out.println("Deleted " + studentDAO.deleteAll() + " rows");
    }

    private void deleteStudent(StudentDAO studentDAO) {
        studentDAO.delete(1);
        System.out.println("Deleted the student with id 1");
    }

    private void updateStudentName(StudentDAO studentDAO) {
        Student theStudent = studentDAO.findById(1);

        theStudent.setLastName("Doe");

        studentDAO.update(theStudent);

        System.out.println(theStudent);
    }

    private void queryStudentByLastName(StudentDAO studentDAO, String lastName) {
        List<Student> students = studentDAO.findByLastName(lastName);

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void findAllStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void retrieveStudent(StudentDAO studentDAO, int i) {
        System.out.println("Finding the student..");
        Student student = studentDAO.findById(i);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("No student found with id: " + i);
        }
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating 3 new student object");

        Student student1 = new Student("John", "Doe", "johndoe@gmail.com");
        Student student2 = new Student("Mary", "Public", "mary@gmail.com");
        Student student3 = new Student("Jaime", "Lannister", "lannisterjaime@gmail.com");


        System.out.println("Saving students..");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating a new student object");

        Student student = new Student("Minal", "Amesur", "minalamesur@gmail.com");

        studentDAO.save(student);

        System.out.println("Saved the student. Generated id: " + student.getId());
    }
}
