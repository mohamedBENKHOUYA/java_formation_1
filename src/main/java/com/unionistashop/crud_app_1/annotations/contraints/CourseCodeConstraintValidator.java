package com.unionistashop.crud_app_1.annotations.contraints;

import com.unionistashop.crud_app_1.annotations.CourseCode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode coursePrefix) {
        this.coursePrefix = coursePrefix.value();
//        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {

        return code != null ? code.startsWith(this.coursePrefix): false;
    }
}
