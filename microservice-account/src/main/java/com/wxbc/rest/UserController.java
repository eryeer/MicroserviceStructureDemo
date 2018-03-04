package com.wxbc.rest;

import com.wxbc.common.CommonConst;
import com.wxbc.common.ResponseFormat;
import com.wxbc.common.ReturnCode;
import com.wxbc.pojo.UserInfo;
import com.wxbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/user/rest")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/getUserInfo", produces = {CommonConst.PRODUCE}, method = RequestMethod.GET)
    public UserInfo getUserInfo(@RequestParam("name") String name) {
        UserInfo userInfo = userService.getUserInfo(name);
        return userInfo;
    }
}
