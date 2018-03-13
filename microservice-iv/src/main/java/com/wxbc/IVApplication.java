package com.wxbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient //声明eureka客户端
@SpringBootApplication
@MapperScan(basePackages = {"com.wxbc"})
@EnableTransactionManagement
//@EnableHystrix
//@EnableFeignClients
@PropertySource(value = {"classpath:redis.properties","classpath:jdbc.properties","classpath:rabbitmq.properties"}, ignoreResourceNotFound = true)
public class IVApplication {
    public static void main(String[] args) {
        SpringApplication.run(IVApplication.class, args);
    }

    @Bean // 向Spring容器中定义RestTemplate对象
    @LoadBalanced //开启负载均衡
    public RestTemplate restTemplate() {

        OkHttp3ClientHttpRequestFactory requestFactory = new OkHttp3ClientHttpRequestFactory();
        requestFactory.setConnectTimeout(20000);
        requestFactory.setReadTimeout(20000);
        requestFactory.setWriteTimeout(20000);
        return new RestTemplate(requestFactory);
    }
}
