/**
 * Date:     2018/11/1715:55
 * AUTHOR:   Administrator
 */
package com.zhou.base_004;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

import java.lang.ref.SoftReference;
import java.util.Map;

/**
 * 软引用对象 案例
 * 2018/11/17  15:55
 * created by zhoumb
 */
public class SoftReferenceCase {
    public static void main(String[] args) {
        Map<String, String> userInfo = Maps.newHashMap();
        userInfo.put("user_one", "fxx");
        userInfo.put("user_two", "fd");
        userInfo.put("user_three", "fds");
        userInfo.put("user_four", "fss");
        userInfo.put("user_five", "fff");
        SoftReference<Map<String, String>> userInfoSoftReference = new SoftReference<>(userInfo);
        System.gc();
        Map<String, String> stringStringMap = userInfoSoftReference.get();
        System.out.println(JSON.toJSONString(stringStringMap));
        stringStringMap.put("user_template", "fsd");
        System.out.println(userInfoSoftReference.get());
    }
}
