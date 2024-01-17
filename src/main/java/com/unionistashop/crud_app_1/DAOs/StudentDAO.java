package com.unionistashop.crud_app_1.DAOs;

import com.unionistashop.crud_app_1.entities.Student;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


public interface StudentDAO {

    void save(Student student);

    Student find(int id);


    List<Student> findAll();

    Student update(Student student);


    Student delete(int id);


    int deleteAll();


}
