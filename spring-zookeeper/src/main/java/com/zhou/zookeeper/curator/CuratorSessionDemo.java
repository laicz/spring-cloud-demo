/**
 * Date:     2018/8/2123:22
 * AUTHOR:   Administrator
 */
package com.zhou.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.net.ConnectException;

/**
 * 2018/8/21  23:22
 * created by zhoumb
 */
public class CuratorSessionDemo {

    private static final String CONNECTED_ADDR = "192.168.58.148:2181,192.168.58.147:2181,192.168.58.156:2181";

    public static void main(String[] args) {
        CuratorFramework curatorFramework = CuratorFrameworkFactory
                .newClient(CONNECTED_ADDR, 5000, 5000,
                        new ExponentialBackoffRetry(1000, 3));
        curatorFramework.start();//启动连接

        //链式操作
        CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder().connectString(CONNECTED_ADDR)
                .sessionTimeoutMs(5000)
                .connectionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3));
        CuratorFramework build = builder.build();
        build.start();
    }
}
