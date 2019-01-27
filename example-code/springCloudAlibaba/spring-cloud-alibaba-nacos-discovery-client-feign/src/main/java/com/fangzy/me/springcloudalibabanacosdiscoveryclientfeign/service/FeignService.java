package com.fangzy.me.springcloudalibabanacosdiscoveryclientfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by fangzy on 2019/1/27 16:29
 */
@FeignClient("spring-cloud-alibaba-nacos-discovery-server")
public interface FeignService {
    @GetMapping("/hello")
    String test(@RequestParam("name") String name);
}
