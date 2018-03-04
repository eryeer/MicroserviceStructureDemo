package com.wxbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class TestService {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    public TestService(){

    }
    @PostConstruct
    public void test(){
        String serviceId = "microservice-account";
        for (int i = 0; i < 100; i++) {
            ServiceInstance serviceInstance = loadBalancerClient.choose(serviceId);
            System.out.println("第" + (i + 1) + "次：" + serviceInstance.getHost() + ": " + serviceInstance.getPort());
        }
    }
}
