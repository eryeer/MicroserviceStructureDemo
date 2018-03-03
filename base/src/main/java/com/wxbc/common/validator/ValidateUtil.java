package com.wxbc.common.validator;

import com.wxbc.common.ResponseFormat;
import com.wxbc.common.ReturnCode;
import org.springframework.validation.BindingResult;

public class ValidateUtil {

    public static boolean paramError(BindingResult result, ResponseFormat responseFormat) {
        if(result.hasErrors()){
            responseFormat.setReturnCodeEx(ReturnCode.PARAMETER_ERROR);
            return true;
        }
        return false;
    }
}