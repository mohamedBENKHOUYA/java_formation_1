package com.unionistashop.crud_app_1.annotations;

import com.unionistashop.crud_app_1.annotations.contraints.CourseCodeConstraintValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface CourseCode {
    public String value() default "UN";

    public String message() default "must begin with UN";

//    define default groups
    public Class<?>[] groups() default {};

//    define default payloads
    public Class<? extends Payload>[] payload() default {};


}
