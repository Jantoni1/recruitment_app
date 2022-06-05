package com.jantoni1.recruitmentapp.transaction.reward.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RewardRequestYearValidator implements ConstraintValidator<ValidYear, Integer> {

    @Override
    public boolean isValid(Integer year, ConstraintValidatorContext constraintValidatorContext) {
        if(year == null) {
            return false;
        }

        return year >= 1970;
    }

}
