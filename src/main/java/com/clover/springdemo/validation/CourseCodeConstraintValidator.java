package com.clover.springdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String[] coursePrefixes;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefixes = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
        if (theCode != null) {
            for (String coursePrefix : coursePrefixes) {
                if (!theCode.startsWith(coursePrefix)) {
                    return false;
                }
            }
        }
        return true;
    }
}
