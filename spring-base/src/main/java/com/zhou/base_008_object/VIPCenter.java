/**
 * Date:     2018/11/2122:11
 * AUTHOR:   Administrator
 */
package com.zhou.base_008_object;

/**
 * 用户中心  （使用if else实现）
 * 2018/11/21  22:11
 * created by zhoumb
 */
public class VIPCenter {
    /**
     * 业务逻辑集中在一起
     *
     * @param user
     */
    void serviceVIP(User user) {
        if (user instanceof SlumDogVIP) {
            //do something
        } else if (user instanceof RealVIP) {
            //do something
        }
    }
}
