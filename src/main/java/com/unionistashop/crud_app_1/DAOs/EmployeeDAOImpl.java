package com.unionistashop.crud_app_1.DAOs;

import com.unionistashop.crud_app_1.DTOs.CreateEmployeeDto;
import com.unionistashop.crud_app_1.DTOs.UpdateEmployeeDto;
import com.unionistashop.crud_app_1.entities.Employee;
import com.unionistashop.crud_app_1.entities.Student;
import com.unionistashop.crud_app_1.exceptions.EmployeeNotFoundException;
import com.unionistashop.crud_app_1.exceptions.HttpException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager em;

    public EmployeeDAOImpl(EntityManager em) {
        this.em = em;
    }

    public List<Employee> findAll() {
        TypedQuery<Employee> query = this.em.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }


    public Employee findById(int id) {
//        Query query = this.em.createQuery("from Employee where id=:id").setParameter("id", id);
        Employee found = this.em.find(Employee.class, id);

        return found;
    }

    public Employee findBy(String field, String value) {
        Query query = this.em.createQuery(String.format("from Employee where %s=:email", field)).setParameter(field, value);
        try {
            return (Employee) query.getSingleResult();
        }catch(Exception e) {
            return null;
        }
    }

    public Employee save(Employee entity) {
        return this.em.merge(entity);
    }

    public Employee create(CreateEmployeeDto data) {
        return new Employee(data.getFirstName(), data.getLastName(), data.getEmail());
    }


    public Employee deleteById(int id) {
        Employee found = this.findById(id);
        if(found == null) {
            throw new EmployeeNotFoundException(id);
        }

        this.em.remove(found);
        return found;
    }

    public Employee updateById(int id, UpdateEmployeeDto data) {
        Employee found = this.findById(id);
        if(found == null) {
            throw new EmployeeNotFoundException(id);
        }
        if(data.getEmail() != null) {
            found.setEmail(data.getEmail());
        }
        if(data.getFirstName() != null) {
            found.setFirstName(data.getFirstName());
        }
        if(data.getLastName() != null) {
            found.setLastName(data.getLastName());
        }
        return this.em.merge(found);
    }
}
