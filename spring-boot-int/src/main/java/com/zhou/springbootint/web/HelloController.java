/**
 * Date:     2018/6/1321:53
 * AUTHOR:   Administrator
 */
package com.zhou.springbootint.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 实现一个简单的Restful API
 * 2018/6/13  21:53
 * created by zhoumb
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    public String index(){
        return "Hello World";
    }
}
