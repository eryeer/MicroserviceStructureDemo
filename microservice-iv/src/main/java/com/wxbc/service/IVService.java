package com.wxbc.service;


import com.wxbc.common.CommonConst;
import com.wxbc.exception.HystrixFallBackException;
import com.wxbc.mapper.IVInfoDao;
import com.wxbc.pojo.IVInfo;
import com.wxbc.pojo.UserInfo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
public class IVService {

    @Autowired
    private IVInfoDao ivInfoDao;
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private HystrixService hystrixService;

    @Transactional(rollbackFor = Exception.class)
    public IVInfo getIV(String ivAddress) throws HystrixFallBackException {
        IVInfo ivInfo = ivInfoDao.getIVWithIVAddress(ivAddress);
        String name = ivInfo.getName();
//        String serviceId = "microservice-account";
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
        UserInfo userInfo = hystrixService.getUserInfoByName(name); //使用Feign方式调用account模块API
        if (userInfo.getStatus().equals(CommonConst.HYSTRIX_FALLBACK_STATUS)){
            throw new HystrixFallBackException(userInfo.getDesc());
        }
        ivInfo.setUserInfo(userInfo);

        rabbitTemplate.convertAndSend("messageExchange",
                "emailKey", "IV has already got");//通过mq发送Message给接收者
        return ivInfo;
    }


}
