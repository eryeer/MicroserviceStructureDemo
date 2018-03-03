package com.wxbc.service;

import com.wxbc.mapper.UserInfoDao;
import com.wxbc.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoDao userInfoDao;

    public UserInfo getUserInfo(String name) {
        return userInfoDao.queryUserWithName(name);
    }
}
