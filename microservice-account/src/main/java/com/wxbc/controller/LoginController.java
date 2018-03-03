package com.wxbc.controller;

import com.wxbc.pojo.UserInfo;
import com.wxbc.service.LoginService;
import com.wxbc.common.CommonConst;
import com.wxbc.common.ResponseFormat;
import com.wxbc.common.ReturnCode;
import com.wxbc.exception.SqlGetValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginController {
    @Autowired
    private LoginService loginService;

    @ResponseBody
    @RequestMapping(value = "/login", produces = {CommonConst.PRODUCE}, method = RequestMethod.POST)
    public ResponseFormat login(@RequestBody UserInfo userInfo){
        ResponseFormat response = new ResponseFormat(ReturnCode.READ_SUCCESS);
        try {
            loginService.login(userInfo);
        } catch (SqlGetValueException e) {
            response.setReturnCodeEx(ReturnCode.READ_FAILED);
            response.setReturnDesc(e.getMessage());
        } catch (Exception e){
            response.setReturnCodeEx(ReturnCode.READ_FAILED);
        }
        return response;

    }
}
