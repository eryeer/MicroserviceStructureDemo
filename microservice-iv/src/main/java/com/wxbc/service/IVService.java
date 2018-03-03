package com.wxbc.service;


import com.wxbc.mapper.IVInfoDao;
import com.wxbc.pojo.IVInfo;
import com.wxbc.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class IVService {

    // Spring框架对RESTful方式的http请求做了封装，来简化操作
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private IVInfoDao ivInfoDao;
    @Autowired
    private DiscoveryClient discoveryClient;

    public IVInfo getIV(String ivAddress) {
        String serviceId = "microservice-account";
        List<ServiceInstance> instances = this.discoveryClient.getInstances(serviceId);
        if (instances.isEmpty()) {
            return null;
        }
        ServiceInstance serviceInstance = instances.get(0);
        String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();
        IVInfo ivInfo = ivInfoDao.getIVWithIVAddress(ivAddress);
        String name = ivInfo.getName();
        UserInfo userinfo = restTemplate.getForObject("http://" + url + "/rest/user/getUserInfo?name=" + name,
                UserInfo.class);
        ivInfo.setUserInfo(userinfo);
        return ivInfo;
    }
}
