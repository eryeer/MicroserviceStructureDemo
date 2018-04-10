package com.wxbc.feign;

import com.wxbc.common.CommonConst;
import com.wxbc.pojo.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientHystrix implements UserFeignClient{
    @Override
    public UserInfo getUserInfoByName(String name) {
        UserInfo userInfo = new UserInfo();
        userInfo.setDesc("无法获取用户信息111");
        userInfo.setStatus(CommonConst.HYSTRIX_FALLBACK_STATUS);
        return userInfo;
    }
}
