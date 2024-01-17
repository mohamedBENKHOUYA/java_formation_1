package com.unionistashop.crud_app_1.DAOs;

import com.unionistashop.crud_app_1.DTOs.CreateEmployeeDto;
import com.unionistashop.crud_app_1.DTOs.UpdateEmployeeDto;
import com.unionistashop.crud_app_1.entities.Employee;
import com.unionistashop.crud_app_1.services.EmployeeService;

import java.util.List;


public interface EmployeeDAO  {


    List<Employee> findAll();

    Employee create (CreateEmployeeDto data);
    Employee save(Employee entity);

    Employee findById(int id);
    Employee findBy(String field, String value);

    Employee deleteById(int id);

    Employee updateById(int id, UpdateEmployeeDto data);


}
