/**
 * Date:     2018/6/1615:36
 * AUTHOR:   Administrator
 */
package com.zhou.springcloudeurekaproviderhello.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2018/6/16  15:36
 * created by zhoumb
 */
@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/index")
    public String index(){
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        logger.info("/index,host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return "Hello World";
    }
}
