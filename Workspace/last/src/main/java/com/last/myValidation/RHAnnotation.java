package com.last.myValidation;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = TypeConstraintValidator.class)
public @interface RHAnnotation {

    public String value() default "RH";
    public String message() default "Must start with RH";

    //? = n'importe quelle classes
    public Class<?>[] groups() default {};
    //Pour mettre dans la libraire des contraintes de Javax.Validation
    public Class<? extends Payload>[] payloads() default {};
}
