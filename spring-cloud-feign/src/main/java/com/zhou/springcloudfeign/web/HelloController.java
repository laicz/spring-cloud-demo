/**
 * Date:     2018/6/2023:10
 * AUTHOR:   Administrator
 */
package com.zhou.springcloudfeign.web;

import com.zhou.springcloudfeign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2018/6/20  23:10
 * created by zhoumb
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/feign")
    public String feign(){
        return helloService.hello();
    }
}
