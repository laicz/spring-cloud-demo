/**
 * Date:     2018/8/1922:17
 * AUTHOR:   Administrator
 */
package com.zhou.zookeeper.javaapi;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 创建zookeeper会话
 * 2018/8/19  22:17
 * created by zhoumb
 */
public class CreateSessionDemo {

    private static final String CONNECTED_ADDR = "192.168.58.148:2181,192.168.58.147:2181,192.168.58.156:2181";
    //连接zookeeper需要使用countDownLatch来控制，需要一定的时间才能连上
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        try {
            ZooKeeper zooKeeper = new ZooKeeper(CONNECTED_ADDR, 5000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                        countDownLatch.countDown();
                    }
                    System.out.println(watchedEvent.getState());
                }
            });
            countDownLatch.await();
            System.out.println("zookeeper:" + zooKeeper.getState());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
