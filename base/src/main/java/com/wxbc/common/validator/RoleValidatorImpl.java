package com.wxbc.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * Created by administrator on 17-9-25.
 */
public class RoleValidatorImpl implements ConstraintValidator<RoleValidator, List<String>> {
   public void initialize(RoleValidator constraint) {

   }

   public boolean isValid(List<String> obj, ConstraintValidatorContext context) {

      if(obj==null ||obj.size()==0){
         return true;
      }

      if(obj.size()>3){
         return false;
      }

      for(String role:obj){
         if(role==null){
            return false;
         }
      }

      return true;
   }
}
