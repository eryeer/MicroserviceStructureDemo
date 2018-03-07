package com.wxbc.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wxbc.common.CommonConst;
import com.wxbc.feign.UserFeignClient;
import com.wxbc.mapper.IVInfoDao;
import com.wxbc.pojo.IVInfo;
import com.wxbc.pojo.UserInfo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class IVService {

    @Autowired
    private IVInfoDao ivInfoDao;
    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @HystrixCommand(fallbackMethod = "getIVFallback") // 进行容错处理
    public IVInfo getIV(String ivAddress) {
        IVInfo ivInfo = ivInfoDao.getIVWithIVAddress(ivAddress);
        String name = ivInfo.getName();
        String serviceId = "microservice-account";
//        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
//        if(instances.isEmpty()){
//            return null;
//        }
//        // 为了演示，在这里只获取一个实例
//        ServiceInstance serviceInstance = instances.get(0);
//        String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();
//        UserInfo userInfo = this.restTemplate.getForObject("http://" + url + "/user/rest/getUserInfo?name=" + name, UserInfo.class);
//        UserInfo userInfo = restTemplate.getForObject("http://" + serviceId +
//               "/user/rest/getUserInfo?name=" + name, UserInfo.class); //Ribbon开启负载均衡写法
        UserInfo userInfo = userFeignClient.getUserInfoByName(name); //使用Feign方式调用account模块API
        ivInfo.setUserInfo(userInfo);

        rabbitTemplate.convertAndSend("messageExchange",
                "emailKey", "IV has already got");//通过mq发送Message给接收者
        return ivInfo;
    }

    public IVInfo getIVFallback(String ivAddress) { // 请求失败执行的方法
        IVInfo ivInfo = new IVInfo();
        ivInfo.setDesc("无法获取用户信息");
        ivInfo.setStatus(CommonConst.HYSTRIX_FALLBACK_STATUS);
        return ivInfo;
    }
}
