package com.unionistashop.crud_app_1.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class StudentNotFoundException extends HttpException{

    public StudentNotFoundException(int id) {
        super(HttpStatus.NOT_FOUND.value(), "student not found - " + id, System.currentTimeMillis());
    }




}
