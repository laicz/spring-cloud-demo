/**
 * Date:     2018/8/2122:52
 * AUTHOR:   Administrator
 */
package com.zhou.zookeeper.client;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;

/**
 * 2018/8/21  22:52
 * created by zhoumb
 */
public class ApiOperationDemo {
    private static final String CONNECTED_ADDR = "192.168.58.148:2181,192.168.58.147:2181,192.168.58.156:2181";

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static ZkClient getInstance() {
        return new ZkClient(CONNECTED_ADDR, 5000);
    }

    public static void main(String[] args) throws InterruptedException {
        ZkClient zkClient = getInstance();
        /*zkClient.createEphemeral("/zkClient");
        zkClient.createPersistent("", true);
        zkClient.delete("");
        zkClient.deleteRecursive("");//递归删除
        zkClient.getChildren("");//获取子节点*/
        zkClient.subscribeDataChanges("/mic", new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("节点更改 —— 》 ");
                countDownLatch.countDown();
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {

            }
        });//订阅数据变化
        zkClient.writeData("/mic", "new mic");
        countDownLatch.await();
        Object o = zkClient.readData("/mic");
        System.out.println(o);

    }
}
