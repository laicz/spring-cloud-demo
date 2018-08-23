/**
 * Date:     2018/8/2222:51
 * AUTHOR:   Administrator
 */
package com.zhou.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.Executors;

/**
 * 2018/8/22  22:51
 * created by zhoumb
 */
public class CuratorOperatorDemo {

    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorClientUtils.getInstance();
        System.out.println("连接成功----------------->success");

        //fluent风格
        /**
         * 创建节点
         */
        /*String result = curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
                .forPath("/curator/curator1/curator11", "123".getBytes());
        System.out.println(result);*/

        /**
         * 删除节点
         */
        /*Void aVoid = curatorFramework.delete().deletingChildrenIfNeeded().forPath("/mic");
        System.out.println(aVoid);*/

        /**
         * 获取节点
         */
        /*Stat stat = new Stat();
        byte[] bytes = curatorFramework.getData().storingStatIn(stat).forPath("/curator/curator1/curator11");
        System.out.println(new String(bytes));
        System.out.println(stat);*/

        /**
         * 更新
         */
        /*Stat stat = curatorFramework.setData().forPath("/curator", "456".getBytes());
        System.out.println(stat);*/

        /**
         * 异步操作
         */
        curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL)
                .inBackground(new BackgroundCallback() {
                    @Override
                    public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                        System.out.println(Thread.currentThread().getName());
                    }
                }, Executors.newSingleThreadExecutor()).forPath("/mic", "123".getBytes());


        /**
         * 事务操作(curator独有的)
         */
        curatorFramework.inTransaction().create().forPath("")
                .and()
                .setData().forPath("")
                .and().commit();

    }
}
