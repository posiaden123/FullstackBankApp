package org.posiaden.bank.auth;

import org.posiaden.bank.annotation.Name;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class NameValidator implements ConstraintValidator<Name,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if( s == null) return false;
        return s.chars().allMatch(Character::isLetter);
    }


}
