/**
 * Date:     2018/8/2122:47
 * AUTHOR:   Administrator
 */
package com.zhou.zookeeper.client;

import org.I0Itec.zkclient.ZkClient;

/**
 * 使用zkClient来操作
 * 2018/8/21  22:47
 * created by zhoumb
 */
public class SessionDemo {
    private static final String CONNECTED_ADDR = "192.168.58.148:2181,192.168.58.147:2181,192.168.58.156:2181";

    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient(CONNECTED_ADDR, 4000);
        System.out.println(zkClient + " -> success");
    }
}
