package com.unionistashop.crud_app_1;

import com.unionistashop.crud_app_1.DAOs.StudentDAO;
import com.unionistashop.crud_app_1.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication()
public class CrudApp1Application {

    public static void main(String[] args) {
        SpringApplication.run(CrudApp1Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {

            //createMultipleStudents(studentDAO);
            createStudent(studentDAO);
        };
    }




private void createMultipleStudents(StudentDAO studentDAO) {
        try {
            Student tempStudent1 = new Student("John", "Hoe", "john@unionistashop.com");
            Student tempStudent2 = new Student("Mary", "Public", "john@unionistashop.com");
            Student tempStudent3 = new Student("Bonita", "Applebum", "john@unionistashop.com");

            System.out.println("Saving the students....");

            studentDAO.save(tempStudent1);
            studentDAO.save(tempStudent2);
            studentDAO.save(tempStudent3);

        }catch(Exception e) {
            System.out.println(e);
        }
}
    private void createStudent(StudentDAO studentDAO) {
        try {
            System.out.println("Creating new student object...");
            Student tempStudent = new Student("paul", "Doe", "paul@email.com");

            studentDAO.save(tempStudent);

            System.out.println("Saed student. Generated id: " + tempStudent.getId());
        } catch(Exception e) {
            System.out.println(e);
        }
    }




}
