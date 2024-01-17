package com.unionistashop.crud_app_1.exceptions;

import org.springframework.http.HttpStatus;

public class EmployeeNotFoundException extends HttpException{

    public EmployeeNotFoundException(int id) {
        super(HttpStatus.NOT_FOUND.value(), "Employee - "+id+" - not found");
    }
}
