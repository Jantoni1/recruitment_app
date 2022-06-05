package com.jantoni1.recruitmentapp.transaction.reward.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RewardRequestMonthValidator implements ConstraintValidator<ValidMonth, Integer> {

    @Override
    public boolean isValid(Integer month, ConstraintValidatorContext context) {
        if(month == null) {
            return false;
        }

        return month > 0 && month <= 12;
    }
}
