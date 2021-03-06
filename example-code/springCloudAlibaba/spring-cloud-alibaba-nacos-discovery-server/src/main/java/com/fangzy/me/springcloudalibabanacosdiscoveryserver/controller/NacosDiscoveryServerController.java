package com.fangzy.me.springcloudalibabanacosdiscoveryserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fangzy on 2019/1/27 11:52
 * 使用nacos作用注册中心
 * 服务提供者的controller
 */
@RestController
public class NacosDiscoveryServerController {
    Logger logger = LoggerFactory.getLogger(NacosDiscoveryServerController.class);

    @GetMapping("/hello")
    public String hello(@RequestParam String name){
        logger.info("提供者请求参数：{}",name );
        return "hello:"+name;
    }
}
