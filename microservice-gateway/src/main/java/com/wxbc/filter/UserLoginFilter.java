package com.wxbc.filter;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.netflix.discovery.converters.Auto;
import com.wxbc.exception.SqlGetValueException;
import com.wxbc.feign.UserFeignClient;
import com.wxbc.pojo.UserInfo;
import com.wxbc.redis.RedisService;
import com.wxbc.service.LoginService;
import com.wxbc.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class UserLoginFilter extends BaseFilter {
    @Autowired
    LoginService loginService;
    @Override
    public String filterType() {
        return "pre"; //使用前置过滤器
    }
    @Override
    public int filterOrder() {
        return 1;
    }
    @Override
    public boolean shouldFilter() {
        HttpServletRequest request = getRequest();
        String requestURI = request.getRequestURI();
        if (requestURI.contains("/login")) { //拦截/login的url
            return true;
        } else {
            return false;
        }
    }
    @Override
    public Object run() {
        HttpServletRequest request = getRequest();
        HttpServletResponse response = getResponse();
        try {
            JSONObject jsonObject = getJsonObject(request);
            if (jsonObject == null){
                throw new Exception("參數不正确");
            }
            String name = jsonObject.getString("name");
            String password = jsonObject.getString("password");
            UserInfo userInfo = new UserInfo();
            userInfo.setName(name);
            userInfo.setPassword(password);
            String loginToken = loginService.login(userInfo);//登陆成功则将loginToken存入cookie，失败抛出异常
            CookieUtils.setCookie(request, response, "LOGIN_TOKEN", loginToken);
            getRequestContext().setResponseBody("login success");
        } catch (Exception e) {
            getRequestContext().setResponseBody(e.getMessage());
        }
        getRequestContext().setSendZuulResponse(false);//将请求直接返回
        response.setContentType("text/html;charset=UTF-8");
        getRequestContext().setResponseStatusCode(200);
        return null;
    }

    private JSONObject getJsonObject(HttpServletRequest request) {
        JSONObject jsonObject = null;
        try {
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null) responseStrBuilder.append(inputStr);
            jsonObject = JSONObject.parseObject (responseStrBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
