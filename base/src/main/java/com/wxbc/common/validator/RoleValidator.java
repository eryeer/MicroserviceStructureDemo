package com.wxbc.common.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by administrator on 17-9-25.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Constraint(validatedBy = RoleValidatorImpl.class)
public @interface RoleValidator {

    String values();

    Class<? extends Payload>[] payload() default {};

    String message() default "role not exist";

    Class<?>[] groups() default {};

}