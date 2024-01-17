package com.unionistashop.crud_app_1.crud_app_2.services;

import com.unionistashop.crud_app_1.DTOs.CreateEmployeeDto;
import com.unionistashop.crud_app_1.crud_app_2.entity.Employee2;

import java.util.List;

public interface EmployeeService2 {
    List<Employee2> list();

    Employee2 create(CreateEmployeeDto data);
}
