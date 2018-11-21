/**
 * Date:     2018/11/2122:20
 * AUTHOR:   Administrator
 */
package com.zhou.base_008_object.grace;

import com.zhou.base_008_object.User;

import java.util.Map;

/**
 * 使用面向对象特性优雅的实现
 * 2018/11/21  22:20
 * created by zhoumb
 */
public class VIPCenter {
    private Map<User.TYPE, ServiceProvider> providers;

    void serviceVIP(User user) {
        providers.get(user.getType()).service();
    }
}
