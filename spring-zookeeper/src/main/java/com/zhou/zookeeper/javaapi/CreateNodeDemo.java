/**
 * Date:     2018/8/1922:40
 * AUTHOR:   Administrator
 */
package com.zhou.zookeeper.javaapi;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 2018/8/19  22:40
 * created by zhoumb
 */
public class CreateNodeDemo {
    private static final Logger logger = LoggerFactory.getLogger(CreateNodeDemo.class);

    private static final String CONNECTED_ADDR = "192.168.58.148:2181,192.168.58.147:2181,192.168.58.156:2181";
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static ZooKeeper zooKeeper;

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        zooKeeper = new ZooKeeper(CONNECTED_ADDR, 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    logger.info("watcher received event");
                    countDownLatch.countDown();
                }

                logger.info("回调watcher1实例：路径：{}，实物类型：{}", watchedEvent.getPath(), watchedEvent.getType());
                Event.EventType type = watchedEvent.getType();
                Event.KeeperState state = watchedEvent.getState();
                String path = watchedEvent.getPath();
                switch (type) {
                    case NodeCreated:
                        logger.info("创建节点");
                        break;
                    case NodeChildrenChanged:
                        try {
                            handleMessage(path);
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        } catch (KeeperException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    case NodeDataChanged:
                        logger.info("节点数据发生变化");
                        break;
                    default:
                        break;
                }
            }

            private void handleMessage(String path) throws UnsupportedEncodingException, KeeperException, InterruptedException {
                logger.info("解析收到的信息");
                List<String> children = this.getChildren(path);
                for (String child : children) {
                    String childPath = path + "/" + child;
                    byte[] bytes = this.getData(childPath);
                    String recString = new String(bytes, "utf-8");
                    logger.info("receive the path :" + childPath + ":data:" + recString);
                    this.deleteNode(childPath, -1);
                }
            }

            private void deleteNode(String childPath, int i) throws KeeperException, InterruptedException {
                zooKeeper.delete(childPath, i);
            }

            private byte[] getData(String childPath) throws KeeperException, InterruptedException {
                return zooKeeper.getData(childPath, true, new Stat());
            }

            private List<String> getChildren(String path) throws KeeperException, InterruptedException {
                //监听该节点子节点的变化情况
                return zooKeeper.getChildren(path, this);
            }
        });
        countDownLatch.await();
        System.out.println("Zookeeper:" + zooKeeper.getState());

        String result = zooKeeper.create("/node", "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("创建成功：" + result);
//        zooKeeper.getData("/node", true, new Stat());

        zooKeeper.setData("/node", "change".getBytes(), -1);

        Thread.sleep(30000);
    }
}
