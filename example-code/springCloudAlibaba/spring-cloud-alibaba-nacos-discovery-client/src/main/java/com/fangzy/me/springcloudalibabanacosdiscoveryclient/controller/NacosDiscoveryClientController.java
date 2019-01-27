package com.fangzy.me.springcloudalibabanacosdiscoveryclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by fangzy on 2019/1/27 11:52
 * 使用nacos作用注册中心
 * 服务消费者的controller
 */
@RestController
public class NacosDiscoveryClientController {
    Logger logger = LoggerFactory.getLogger(NacosDiscoveryClientController.class);

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/test")
    public String hello(@RequestParam String name){
        logger.info("消费者请求参数：{}",name );
        //通过LoadBalancerClient获取服务实例，具有负载功能的
        ServiceInstance serviceInstance = loadBalancerClient.choose("spring-cloud-alibaba-nacos-discovery-server");
        String url = serviceInstance.getUri() + "/hello?name=" + name;
        logger.info("请求接口地址：{}",url);
        String retrunResult = restTemplate.getForObject(url, String.class);
        logger.info("通过nacos作为注册中心调用服务提供方的接口返回的内容:{}",retrunResult);
        return "调用接口返回内容："+retrunResult;
    }
}
