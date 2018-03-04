package com.wxbc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wxbc.common.CommonUtil;
import com.wxbc.exception.SqlGetValueException;
import com.wxbc.feign.UserFeignClient;
import com.wxbc.pojo.UserInfo;
import com.wxbc.redis.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginService {
    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private RedisService redisService;

    public String login(UserInfo userInfo) throws SqlGetValueException, JsonProcessingException {
        UserInfo userTableInfo = userFeignClient.getUserInfoByName(userInfo.getName());
        if (userTableInfo == null) {
            throw new SqlGetValueException("用户不存在");
        }
        if (!StringUtils.equals(userInfo.getPassword(), userTableInfo.getPassword())) {
            throw new SqlGetValueException("用户名或密码错误");
        }
        //save userInfo into redis
        String userValue = CommonUtil.Bean2String(userTableInfo);
        String loginToken = UUID.randomUUID().toString();
        redisService.hset("LOGIN_TOKEN-" + loginToken, "active", userValue);
        redisService.expire("LOGIN_TOKEN-" + loginToken, 300);
        return loginToken;
    }
}
