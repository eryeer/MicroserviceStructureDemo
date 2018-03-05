package com.wxbc.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wxbc.common.CommonConst;
import com.wxbc.feign.UserFeignClient;
import com.wxbc.mapper.IVInfoDao;
import com.wxbc.pojo.IVInfo;
import com.wxbc.pojo.UserInfo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IVService {

    @Autowired
    private IVInfoDao ivInfoDao;
    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private AmqpTemplate rabbitTemplate;


    @HystrixCommand(fallbackMethod = "getIVFallback") // 进行容错处理
    public IVInfo getIV(String ivAddress) {
        IVInfo ivInfo = ivInfoDao.getIVWithIVAddress(ivAddress);
        String name = ivInfo.getName();
        UserInfo userInfo = userFeignClient.getUserInfoByName(name);
        ivInfo.setUserInfo(userInfo);
        rabbitTemplate.convertAndSend("messageExchange","emailKey","IV has already got");
        return ivInfo;
    }

    public IVInfo getIVFallback(String ivAddress) { // 请求失败执行的方法
        IVInfo ivInfo = new IVInfo();
        ivInfo.setDesc("无法获取用户信息");
        ivInfo.setStatus(CommonConst.HYSTRIX_FALLBACK_STATUS);
        return ivInfo;
    }
}
