package ru.digitalchief.validator.cuisine;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CuisineValidator.class)
public @interface ValidCuisine {
    String message() default "Invalid cuisine";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}