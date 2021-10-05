package org.posiaden.bank.auth;

import org.posiaden.bank.annotation.Name;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//Validation class for name annotation
public class NameValidator implements ConstraintValidator<Name,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if( s == null) return false;
        //Name can only contain letters
        return s.chars().allMatch(Character::isLetter);
    }


}
