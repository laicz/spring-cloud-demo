/**
 * Date:     2018/6/1616:35
 * AUTHOR:   Administrator
 */
package com.zhou.springcloudribbonconsumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

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
       /* Map<String,String> params = new HashMap<>();
        params.put("name","name");
        restTemplate.getForEntity("http://HELLO-SERVICE/user?name={name}",String.class,params);

        UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://HELLO-SERVICE/user?name={name}").build().expand(params).encode();
        URI uri = uriComponents.toUri();*/

        System.out.println("》》》》》》》》》接收到请求《《《《《《《《");
        return restTemplate.getForEntity("http://HELLO-SERVICE/index",String.class).getBody();
    }
}
