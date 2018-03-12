package com.wxbc.rest;

import com.wxbc.common.CommonConst;
import com.wxbc.common.ResponseFormat;
import com.wxbc.common.ReturnCode;
import com.wxbc.config.JdbcConfigBean;
import com.wxbc.pojo.UserInfo;
import com.wxbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/user/rest")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JdbcConfigBean jdbcConfigBean;
    @Value("${server.port}")
    private String port;

    @ResponseBody
    @RequestMapping(value = "/getUserInfo", produces = {CommonConst.PRODUCE}, method = RequestMethod.GET)
    public UserInfo getUserInfo(@RequestParam("name") String name) {
        //System.out.println("start to getUserInfo: " + port);
        UserInfo userInfo = userService.getUserInfo(name);
        return userInfo;
    }


    @ResponseBody
    @RequestMapping(value = "/test", produces = {CommonConst.PRODUCE}, method = RequestMethod.GET)
    public ResponseFormat test() {
        ResponseFormat responseFormat = new ResponseFormat(ReturnCode.READ_SUCCESS);
        ArrayList<String> strings = new ArrayList<>();
        strings.add(this.jdbcConfigBean.toString());
        responseFormat.setItems(strings);
        return responseFormat;
    }
}
