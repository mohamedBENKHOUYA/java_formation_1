package com.unionistashop.crud_app_1.services;

import com.unionistashop.crud_app_1.DTOs.CreateEmployeeDto;
import com.unionistashop.crud_app_1.DTOs.UpdateEmployeeDto;
import com.unionistashop.crud_app_1.entities.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> list();

    Employee create(CreateEmployeeDto data);

    Employee delete(int id);

    Employee findOne(int id);

    Employee update(int id, UpdateEmployeeDto data);
}
