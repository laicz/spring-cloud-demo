/**
 * Date:     2018/8/2223:26
 * AUTHOR:   Administrator
 */
package com.zhou.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.*;

import java.util.concurrent.CountDownLatch;

/**
 * 2018/8/22  23:26
 * created by zhoumb
 */
public class CuratorEventDemo {
    public static void main(String[] args) throws Exception {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        CuratorFramework curatorFramework = CuratorClientUtils.getInstance();

        NodeCache nodeCache = new NodeCache(curatorFramework, "/curator", false);
        nodeCache.start(true);

        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("节点发生变化");
                countDownLatch.countDown();
            }
        });
        curatorFramework.setData().forPath("/curator", "new Curator value".getBytes());
        countDownLatch.await();

        final PathChildrenCache pathChildrenCache = new PathChildrenCache(curatorFramework, "/path", true);
        pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                PathChildrenCacheEvent.Type type = pathChildrenCacheEvent.getType();
                switch (type){
                    case CHILD_ADDED:
                }
            }
        });

    }
}
