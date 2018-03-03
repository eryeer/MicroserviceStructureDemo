package com.wxbc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wxbc.common.CommonUtil;
import com.wxbc.mapper.UserInfoDao;
import com.wxbc.pojo.UserInfo;
import com.wxbc.exception.SqlGetValueException;
import com.wxbc.redis.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginService {
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private RedisService redisService;

    public void login(UserInfo userInfo) throws SqlGetValueException, JsonProcessingException {
        UserInfo userTableInfo = userInfoDao.queryUserWithName(userInfo.getName());
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
        redisService.setex("USER_INFO-" + userInfo.getName(), userValue, 30000);
    }
}
