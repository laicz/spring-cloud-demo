/**
 * Date:     2018/6/2022:32
 * AUTHOR:   Administrator
 */
package com.zhou.springcloudribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 2018/6/20  22:32
 * created by zhoumb
 */
@Service
public class ConsumerHystrixService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 使用@HystrixCommand注释的方法会使用熔断器
     * @return
     */
    @HystrixCommand(fallbackMethod = "helloFail")
    public String hystrix() {
//        restTemplate.exchange()
        return restTemplate.getForEntity("http://HELLO-SERVICE/index",String.class).getBody();
    }

    public String helloFail() {
        return "restTemplate fail,return fallBackMethod";
    }
}
