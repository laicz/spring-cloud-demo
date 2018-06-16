/**
 * Date:     2018/6/1616:35
 * AUTHOR:   Administrator
 */
package com.zhou.springcloudribbonconsumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 2018/6/16  16:35
 * created by zhoumb
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consumer")
    public String helloConsumer(){
        System.out.println("》》》》》》》》》接收到请求《《《《《《《《");
        return restTemplate.getForEntity("http://HELLO-SERVICE/index",String.class).getBody();
    }
}
