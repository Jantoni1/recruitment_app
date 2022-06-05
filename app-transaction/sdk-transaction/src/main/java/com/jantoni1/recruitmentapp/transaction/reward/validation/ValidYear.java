package com.jantoni1.recruitmentapp.transaction.reward.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {RewardRequestYearValidator.class})
public @interface ValidYear {

    String message() default "Invalid year provided";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
