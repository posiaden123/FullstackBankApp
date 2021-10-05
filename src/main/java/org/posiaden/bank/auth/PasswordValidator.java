package org.posiaden.bank.auth;

import org.posiaden.bank.annotation.Password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.logging.Logger;
import java.util.regex.Pattern;
//Validation class for @Password annotation
public class PasswordValidator implements ConstraintValidator<Password,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {return false;}
        boolean captial = Pattern.compile("[A-Z]").matcher(s).find();
        boolean lower = Pattern.compile("[a-z]").matcher(s).find();
        boolean special = Pattern.compile("[$&+,:;=\\\\?@#|/'<>.^*()%!-]").matcher(s).find();
        //make sure no illegal characters present in password
        return captial && lower && special;
    }
}
