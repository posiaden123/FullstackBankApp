package org.posiaden.bank.annotation;

import org.posiaden.bank.auth.NameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Annotation to validate a proper first and last name in the sign-up form
//Used in AccountDTO
@Constraint(validatedBy = NameValidator.class)
@Target({ElementType.ANNOTATION_TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Name {
    String message() default "Must enter a proper name";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
