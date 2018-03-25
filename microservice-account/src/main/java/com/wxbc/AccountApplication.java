package com.wxbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient //声明eureka客户端
@SpringBootApplication
@MapperScan(basePackages = {"com.wxbc"})
@EnableTransactionManagement
@PropertySource(value = {"classpath:conf.properties"})
public class AccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
}
