/**
 * Date:     2018/6/2023:10
 * AUTHOR:   Administrator
 */
package com.zhou.springcloudfeign.web;

import com.zhou.common.model.User;
import com.zhou.springcloudfeign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String feign() {
        return helloService.hello();
    }

    @GetMapping("/feign2")
    public String feign2() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(helloService.hello()).append("\n");
        stringBuilder.append(helloService.hello("DIDI")).append("\n");
        stringBuilder.append(helloService.hello("DIDI", 100)).append("\n");
        stringBuilder.append(helloService.hello(new User("DIDI", 30))).append("\n");
        return stringBuilder.toString();
    }
}
