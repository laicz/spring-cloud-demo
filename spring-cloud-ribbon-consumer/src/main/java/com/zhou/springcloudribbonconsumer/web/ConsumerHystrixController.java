/**
 * Date:     2018/6/2022:30
 * AUTHOR:   Administrator
 */
package com.zhou.springcloudribbonconsumer.web;

import com.netflix.discovery.converters.Auto;
import com.zhou.springcloudribbonconsumer.service.ConsumerHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2018/6/20  22:30
 * created by zhoumb
 */
@RestController
public class ConsumerHystrixController {

    @Autowired
    private ConsumerHystrixService consumerHystrixService;

    @RequestMapping(value = "/hystrix")
    public String hystrix() {
        return consumerHystrixService.hystrix();
    }
}
