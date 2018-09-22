/**
 * Date:     2018/9/1721:34
 * AUTHOR:   Administrator
 */
package com.zhou.springdata.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2018/9/17  21:34
 * created by zhoumb
 */
@RestController
@RequestMapping(value = "/request")
public class RequestMethodController {

    @RequestMapping(value = "/get/params")
    public void getParams(String userId, String cardId) {
        System.out.println("userId:" + userId + " , cardId : {}" + cardId);
    }
}
