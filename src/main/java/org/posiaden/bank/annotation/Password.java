package org.posiaden.bank.annotation;


import org.posiaden.bank.auth.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Validation annotation for password in sign up form
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.ANNOTATION_TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String message() default "Password must contain at least 1 captial letter, 1 lowercase letter, and 1 special character";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
