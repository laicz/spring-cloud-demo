/**
 * Date:     2018/6/1615:36
 * AUTHOR:   Administrator
 */
package com.zhou.springcloudeurekaproviderhello.web;

import com.alibaba.fastjson.JSON;
import com.zhou.common.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 请求含有参数
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello(@RequestParam String name){
        return "Hello:" + name;
    }

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public User hello(@RequestHeader String name,@RequestHeader Integer age){
        return new User(name,age);
    }

    /**
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/hello3")
    public String hello(@RequestBody User user){
        return JSON.toJSONString(user);
    }
}
