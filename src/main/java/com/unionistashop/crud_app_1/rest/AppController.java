package com.unionistashop.crud_app_1.rest;

import com.unionistashop.crud_app_1.DAOs.StudentDAO;
import com.unionistashop.crud_app_1.entities.Student;
import com.unionistashop.crud_app_1.exceptions.ExceptionBody;
import com.unionistashop.crud_app_1.exceptions.HttpException;
import com.unionistashop.crud_app_1.exceptions.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping()
public class AppController {


    @PostConstruct
    public void loadData() {
        System.out.println("load data works !");
    }

    StudentDAO studentDAO;
    @Autowired
    public AppController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }



    @GetMapping("/{id}")
    public Student find(@PathVariable int id) {
        Student found = this.studentDAO.find(id);
        if(found == null) {
            throw new StudentNotFoundException(id);
        }
        return found;
    }

    @GetMapping("list")
    public List<Student> getStudents() {
        List<Student> students =  this.studentDAO.findAll();

        return students;
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable int id, @RequestBody Student student) {
        Student found = this.find(id);
         if(student.getFirstName() != null) {
             found.setFirstName(student.getFirstName());
         }
        if(student.getLastName() != null) {
            found.setLastName(student.getLastName());
        }
        System.out.println("bodyemail: " + student.getEmail());
        if(student.getEmail() != null) {
            found.setEmail(student.getEmail());
        }

        this.studentDAO.update(found);

        return found;
    }

    @DeleteMapping("/{id}/delete")
    public Student delete(@PathVariable int id) {
        return this.studentDAO.delete(id);
    }

    @DeleteMapping ("")
    public int deleteAll() {
        return this.studentDAO.deleteAll();
    }

    @Autowired
    private void createStudent(@Qualifier("studentDAOImpl") StudentDAO studentDAO) {

    }


}


