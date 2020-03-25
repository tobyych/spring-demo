package com.clover.springdemo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    public String[] value() default {"LUV", "ABC", "DEF"};

    public String message() default "must start with LUV, ABC or DEF";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
