package com.unionistashop.crud_app_1.DAOs;

import com.unionistashop.crud_app_1.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;


@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager em;

    public StudentDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public void save(Student student) {
        this.em.persist(student);
    }

    @Override
    public Student find(int id){
        return this.em.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        return  this.em.createQuery("From Student order by lastName", Student.class).getResultList();

    }

    @Override
    @Transactional
    public Student update(Student student) {
        return this.em.merge(student);
    }

    @Override
    @Transactional
    public Student delete(int id) {
        Student found = this.find(id);
        this.em.createQuery("DELETE FROM Student WHERE id=:id").setParameter("id", found.getId()).executeUpdate();
        return found;
    }

    @Override
    @Transactional
    public int deleteAll() {
        return this.em.createQuery("DELETE FROM Student").executeUpdate();
    }
}
