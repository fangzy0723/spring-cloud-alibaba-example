package com.fangzy.me.springcloudalibabanacosdiscoveryclientfeign.controller;

import com.fangzy.me.springcloudalibabanacosdiscoveryclientfeign.service.FeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fangzy on 2019/1/27 16:31
 */
@RestController
public class FeignController {
    private Logger logger = LoggerFactory.getLogger(FeignController.class);

    @Autowired
    private FeignService feignService;

    @GetMapping("/test/{name}")
    public String test(@PathVariable String name){
        logger.info("请求参数：{}",name);
        String result = feignService.test(name);
        logger.info("调用远程接口返回内容：{}",result);
        return result;

    }
}
