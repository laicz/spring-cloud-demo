/**
 * Date:     2018/6/2023:11
 * AUTHOR:   Administrator
 */
package com.zhou.springcloudfeign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 2018/6/20  23:11
 * created by zhoumb
 */
@FeignClient("hello-service")
public interface HelloService {

    @RequestMapping("/index")
    String hello();
}
