package com.wxbc.common;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by administrator on 17-9-21.
 */
@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class CommonController {

    @RequestMapping(value = "/syncTime", method = RequestMethod.GET)
    @ApiOperation(value = "获取服务器时间", notes = "获取服务器时间")
    @ResponseBody
    public ResponseFormat getSyncTime() {
        ResponseFormat responseFormat = new ResponseFormat(ReturnCode.READ_SUCCESS);
        List<Long> items = new ArrayList<>();
        items.add(System.currentTimeMillis());

        responseFormat.setItems(items);

        return responseFormat;
    }

    @RequestMapping(value = "/logerror", method = RequestMethod.GET)
    @ApiOperation(value = "登录失败", notes = "登录失败")
    @ResponseBody
    public ResponseFormat logerror() {
        ResponseFormat responseFormat = new ResponseFormat(ReturnCode.SESSION_EXPIRED);
        return responseFormat;
    }

    @RequestMapping(value = "/returncode", method = RequestMethod.GET)
    @ApiOperation(value = "获取所有响应码", notes = "获取所有响应码")
    @ResponseBody
    public ResponseFormat returncode() {
        ResponseFormat responseFormat = new ResponseFormat(ReturnCode.READ_SUCCESS);

        List<String> codes =new ArrayList<>();

        for(ReturnCode code:ReturnCode.values()){
            codes.add(code.toString());
        }

        responseFormat.setItems(codes);
        return responseFormat;
    }
}
