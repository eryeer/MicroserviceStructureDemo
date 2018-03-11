package com.wxbc.security.service;


import com.wxbc.mapper.UserInfoDao;
import com.wxbc.pojo.UserInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@Component
public class CustomUserService implements UserDetailsService {
    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public UserDetails loadUserByUsername(String username) {


        UserInfo keyInfo = userInfoDao.selectUserInfoByName(username);
        Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();


        if (!StringUtils.isEmpty(keyInfo.getRole1())) {
            auths.add(new SimpleGrantedAuthority(keyInfo.getRole1()));
        }
        if (!StringUtils.isEmpty(keyInfo.getRole2())) {
            auths.add(new SimpleGrantedAuthority(keyInfo.getRole2()));
        }


        User user = new User(keyInfo.getName(), keyInfo.getPassword(), true, true, true, true, auths);
        return user;

    }

}
