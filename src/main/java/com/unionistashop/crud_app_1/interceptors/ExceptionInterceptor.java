package com.unionistashop.crud_app_1.interceptors;

import com.unionistashop.crud_app_1.exceptions.ExceptionBody;
import com.unionistashop.crud_app_1.exceptions.HttpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionInterceptor {
    // add exception handling code here
    @ExceptionHandler
    public ResponseEntity<HttpException> handleException(Exception exc) {
        ExceptionBody exceptionBody;

        if (exc instanceof HttpException) {
            HttpException exception = (HttpException) exc;
            ArrayList<String> errorMessages = new ArrayList<>();
            errorMessages.add(exception.getMessage());
            exceptionBody = new ExceptionBody(exception.getStatus(), errorMessages, exception.getTimeStamp());
            return new ResponseEntity(exceptionBody, HttpStatusCode.valueOf(exception.getStatus()));
        } else if (exc instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) exc;

            ArrayList<String> errorMessages = new ArrayList();
            exception.getBindingResult().getAllErrors().forEach((error) -> {

                FieldError fieldError = (FieldError) error;
                String field = fieldError.getField();
                String message = fieldError.getDefaultMessage();
                errorMessages.add(field + " " + message);

            });
            exceptionBody = new ExceptionBody(exception.getStatusCode().value(), errorMessages, System.currentTimeMillis());

            return new ResponseEntity(exceptionBody, HttpStatus.BAD_REQUEST);
        } else {
            ArrayList<String> errorMessages = new ArrayList<>();
            errorMessages.add(exc.getMessage());
            exceptionBody = new ExceptionBody(HttpStatus.BAD_REQUEST.value(), errorMessages, System.currentTimeMillis());
            return new ResponseEntity(exceptionBody, HttpStatus.BAD_REQUEST);
        }

    }
}
