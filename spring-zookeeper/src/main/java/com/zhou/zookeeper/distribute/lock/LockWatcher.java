/**
 * Date:     2018/8/2521:46
 * AUTHOR:   Administrator
 */
package com.zhou.zookeeper.distribute.lock;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.CountDownLatch;

/**
 * 节点监控
 * 2018/8/25  21:46
 * created by zhoumb
 */
public class LockWatcher implements Watcher {
    private CountDownLatch countDownLatch;

    public LockWatcher(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void process(WatchedEvent event) {
        if (event.getType() == Event.EventType.NodeDeleted) {
            countDownLatch.countDown();
        }

    }
}
