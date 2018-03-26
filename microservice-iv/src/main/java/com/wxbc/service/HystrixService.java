package com.wxbc.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wxbc.common.CommonConst;
import com.wxbc.feign.UserFeignClient;
import com.wxbc.pojo.BasePojoInfo;
import com.wxbc.pojo.IVInfo;
import com.wxbc.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class HystrixService {
    @Autowired
    private UserFeignClient userFeignClient;

    @HystrixCommand(fallbackMethod = "getUserFallback") // 进行容错处理
    public UserInfo getUserInfoByName(String name) {
        return userFeignClient.getUserInfoByName(name);
    }
    public UserInfo getUserFallback(String name) { // 请求失败执行的方法
        UserInfo userInfo = new UserInfo();
        userInfo.setDesc("无法获取用户信息");
        userInfo.setStatus(CommonConst.HYSTRIX_FALLBACK_STATUS);
        return userInfo;
    }
}
