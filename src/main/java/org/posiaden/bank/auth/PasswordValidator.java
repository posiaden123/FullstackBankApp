package org.posiaden.bank.auth;

import org.posiaden.bank.annotation.Password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password,String> {
    Logger logger = Logger.getLogger(getClass().getName());
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {return false;}
        boolean captial = Pattern.compile("[A-Z]").matcher(s).find();
        boolean lower = Pattern.compile("[a-z]").matcher(s).find();
        boolean special = Pattern.compile("[$&+,:;=\\\\?@#|/'<>.^*()%!-]").matcher(s).find();
        logger.info("Capital: " + captial);
        logger.info("Lower: " + lower);
        logger.info("Special: " + special);
        return captial && lower && special;
    }
}
