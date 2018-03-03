package com.wxbc.common.validator;

import com.wxbc.servicebean.cou.CancelDFCBean;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.util.List;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Constraint(validatedBy = IsOverBatchLimit.ValidBatchLimit.class)
public @interface IsOverBatchLimit {

    Class<? extends Payload>[] payload() default {};

    String message() default "超过批处理最大量！";

    Class<?>[] groups() default {};

    class ValidBatchLimit implements ConstraintValidator<IsOverBatchLimit,List>{
        @Override
        public void initialize(IsOverBatchLimit constraint){}

        @Override
        public boolean isValid(List obj, ConstraintValidatorContext context){
            if(obj!=null && obj.size()<=30){
                return true;
            }
            else return false;
        }
    }
}