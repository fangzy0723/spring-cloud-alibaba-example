package com.fangzy.me.springcloudalibabanacosdiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudAlibabaNacosDiscoveryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaNacosDiscoveryServerApplication.class, args);
    }

}

