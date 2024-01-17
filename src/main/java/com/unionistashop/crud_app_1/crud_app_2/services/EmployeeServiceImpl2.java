package com.unionistashop.crud_app_1.crud_app_2.services;


import com.unionistashop.crud_app_1.DTOs.CreateEmployeeDto;
import com.unionistashop.crud_app_1.crud_app_2.mappers.Employee2Mapper;
import com.unionistashop.crud_app_1.crud_app_2.repos.EmployeeRepository2;
import com.unionistashop.crud_app_1.crud_app_2.entity.Employee2;
import com.unionistashop.crud_app_1.exceptions.HttpException;
import com.unionistashop.crud_app_1.mappers.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl2 implements  EmployeeService2 {

    private EmployeeRepository2 employeeRepository;


    @Autowired()
    Employee2Mapper employee2Mapper;

//    @Autowired()
    public EmployeeServiceImpl2(EmployeeRepository2 employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee2> list() {
        return this.employeeRepository.findAll();
//        ArrayList<Employee2> arr = new ArrayList<Employee2>();

//        arr.add(new Employee2(2, "Mohamed", "Moustapha", "mohamed.bben khouy@gmail.com"));
//        return arr;
    }




    public Employee2 create(CreateEmployeeDto data) {
        Optional<Employee2> found = this.employeeRepository.findByEmail(data.getEmail());

        if(found.isPresent()) {
            throw new HttpException(HttpStatus.CONFLICT.value(), "Employee Already exists");
        }
        Employee2 entity = new Employee2();
        this.employee2Mapper.Employee2FromDto(data, entity);
        return this.employeeRepository.save(entity);
    }
}
