/**
 * Date:     2018/11/1716:04
 * AUTHOR:   Administrator
 */
package com.zhou.base_004;

import com.google.common.collect.Maps;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 弱引用案例
 * <p>
 * 2018/11/17  16:04
 * created by zhoumb
 */
public class WeakReferenceCase {
    public static void main(String[] args) throws InterruptedException {
        Map<String, String> userInfo = Maps.newHashMap();
        userInfo.put("user_one", "fxx");
        userInfo.put("user_two", "fd");
        userInfo.put("user_three", "fds");
        userInfo.put("user_four", "fss");
        userInfo.put("user_five", "fff");
        WeakReference<Map<String, String>> userInfoWeakReference = new WeakReference<>(userInfo);
        System.gc();
        TimeUnit.SECONDS.sleep(20L);
        System.out.println(userInfoWeakReference.get());
    }
}
