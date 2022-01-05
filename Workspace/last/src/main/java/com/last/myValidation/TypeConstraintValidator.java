package com.last.myValidation;

import com.last.repository.CitoyenRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TypeConstraintValidator implements ConstraintValidator<RHAnnotation, String> {

    private String type;
    @Autowired
    CitoyenRepository repository;



    @Override
    public void initialize(RHAnnotation constraintAnnotation) {
        type = constraintAnnotation.value();


    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        boolean flag;
        if(str != null) {
            str.startsWith(type);
        }
        else{
            flag = true;
        }

        return false;
    }
}
