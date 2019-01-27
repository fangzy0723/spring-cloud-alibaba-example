package com.fangzy.me.Nacosdiscoveryclientresttemplate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by fangzy on 2019/1/27 15:14
 */
@RestController
public class ClientRestTemplateController {

    Logger logger = LoggerFactory.getLogger(ClientRestTemplateController.class);
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/test")
    public String hello(@RequestParam String name){
        logger.info("消费者请求参数：{}",name );
        String url = "http://spring-cloud-alibaba-nacos-discovery-server/hello?name="+name;
        String retrunResult = restTemplate.getForObject(url, String.class);
        logger.info("通过nacos作为注册中心使用RestTemplate负载调用服务提供方的接口返回的内容:{}",retrunResult);
        return "调用接口返回内容："+retrunResult;
    }
}
