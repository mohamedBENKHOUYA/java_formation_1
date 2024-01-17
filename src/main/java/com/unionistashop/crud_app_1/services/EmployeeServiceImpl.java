package com.unionistashop.crud_app_1.services;

import com.unionistashop.crud_app_1.DAOs.EmployeeDAO;
import com.unionistashop.crud_app_1.DAOs.EmployeeRepository;
import com.unionistashop.crud_app_1.DTOs.CreateEmployeeDto;
import com.unionistashop.crud_app_1.DTOs.UpdateEmployeeDto;
import com.unionistashop.crud_app_1.entities.Employee;
import com.unionistashop.crud_app_1.exceptions.EmployeeNotFoundException;
import com.unionistashop.crud_app_1.exceptions.HttpException;
import com.unionistashop.crud_app_1.mappers.EmployeeMapper;
import jakarta.transaction.Transactional;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> list() {
        return this.employeeRepository.findAll();
    }

    public Employee findOne(int id) {
        Optional<Employee> found = this.employeeRepository.findById(id);
        if(found.isEmpty()) {
            throw new EmployeeNotFoundException(id);
        }
        return found.get();

    }

    @Transactional
    public Employee create(CreateEmployeeDto data) {



        Optional<Employee> found = this.employeeRepository.findByEmail(data.getEmail());
        //System.out.println("founddd: "+found.get().getEmail());
        if(found.isPresent()) {
            throw new HttpException(HttpStatus.NOT_FOUND.value(), "Email already exists", System.currentTimeMillis());
        }
        Employee entity = new Employee();
        this.employeeMapper.employeeFromDto(data, entity);

        return this.employeeRepository.save(entity);
    }

    @Transactional
    public Employee delete(int id) {
        Optional<Employee> found = this.employeeRepository.findById(id);
        if(found.isEmpty()) {
            throw new EmployeeNotFoundException(id);
        }
         this.employeeRepository.deleteById(id);
        return found.get();
    }

    @Transactional
    public Employee update(int id, UpdateEmployeeDto data) {
        Optional<Employee> found = this.employeeRepository.findById(id);
        if(found.isEmpty()) {
            throw new EmployeeNotFoundException(id);
        }
        Employee employee = found.get();
        employeeMapper.employeeFromDto(data, employee);

        System.out.println("employeeee: " + employee.getEmail());

        return this.employeeRepository.save(employee);
    }
}
