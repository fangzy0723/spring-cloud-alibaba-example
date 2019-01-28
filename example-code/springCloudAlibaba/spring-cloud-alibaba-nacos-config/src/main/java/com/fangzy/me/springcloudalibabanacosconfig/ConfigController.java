package com.fangzy.me.springcloudalibabanacosconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fangzy on 2019/1/27 16:55
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${name}")
    private String name;

    @GetMapping("/config")
    public String configTest(){
        return name;
    }
}
