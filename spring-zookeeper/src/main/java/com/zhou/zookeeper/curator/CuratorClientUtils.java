/**
 * Date:     2018/8/2222:52
 * AUTHOR:   Administrator
 */
package com.zhou.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * 2018/8/22  22:52
 * created by zhoumb
 */
public class CuratorClientUtils {
    private static final String CONNECTED_ADDR = "192.168.58.148:2181,192.168.58.147:2181,192.168.58.156:2181";

    private static CuratorFramework curatorFramework;

    public static CuratorFramework getInstance() {
        curatorFramework = CuratorFrameworkFactory.newClient(CONNECTED_ADDR, 5000, 5000,
                new ExponentialBackoffRetry(1000, 3));
        curatorFramework.start();
        return curatorFramework;
    }


}
