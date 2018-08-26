/**
 * Date:     2018/8/2322:42
 * AUTHOR:   Administrator
 */
package com.zhou.zookeeper.distribute.lock;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 2018/8/23  22:42
 * created by zhoumb
 */
public class ZooKeeperClient {
    private static final String CONNECT_STR = "192.168.58.148:2181,192.168.58.147:2181,192.168.58.156:2181";
    private static final int sessionTimeout = 5000;

    public static ZooKeeper getInstance() throws IOException, InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper(CONNECT_STR, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if (event.getState() == Event.KeeperState.SyncConnected) {
                    countDownLatch.countDown();
                }
            }
        });
        countDownLatch.await();
        return zooKeeper;
    }

    public static int getSessionTimeout() {
        return sessionTimeout;
    }
}
