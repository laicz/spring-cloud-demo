/**
 * Date:     2018/8/2122:14
 * AUTHOR:   Administrator
 */
package com.zhou.zookeeper.javaapi;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 2018/8/21  22:14
 * created by zhoumb
 */
public class AuthControlDemo {
    private static final String CONNECTED_ADDR = "192.168.58.148:2181,192.168.58.147:2181,192.168.58.156:2181";
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static ZooKeeper zooKeeper;

    public static void main(String[] args) throws IOException {
        zooKeeper = new ZooKeeper(CONNECTED_ADDR, 5000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

            }
        });


    }
}
