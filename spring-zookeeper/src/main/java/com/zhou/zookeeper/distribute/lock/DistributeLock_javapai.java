/**
 * Date:     2018/8/2322:54
 * AUTHOR:   Administrator
 */
package com.zhou.zookeeper.distribute.lock;

import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * java api 实现分布式锁
 * 2018/8/23  22:54
 * created by zhoumb
 */
public class DistributeLock_javapai {
    private static final String ROOT_LOCKS = "LOCKS";//根节点
    private ZooKeeper zooKeeper;
    private int sessionTimeout;//会话超时时间
    private String lockID;//记录锁ID

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    private static final byte[] data = {1, 2};//节点的数据

    public DistributeLock_javapai() throws IOException, InterruptedException {
        this.zooKeeper = ZooKeeperClient.getInstance();
        this.sessionTimeout = ZooKeeperClient.getSessionTimeout();
    }

    //获取锁的方法
    public boolean lock() {
        try {
            //创建一个临时有序节点
            lockID = zooKeeper.create(ROOT_LOCKS + "/", data,
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

            System.out.println(Thread.currentThread().getName() + " -> 成功创建了节点[" + lockID + "],开始去竞争锁");

            //获取所有的节点
            List<String> children = zooKeeper.getChildren(ROOT_LOCKS, true);
            //进行排序
            SortedSet<String> sortedSet = new TreeSet<>();
            for (String child : children) {
                sortedSet.add(ROOT_LOCKS + "/" + child);
            }
            //获取第一个节点，也是最小的节点
            String first = sortedSet.first();
            if (StringUtils.equals(first, lockID)) {
                System.out.println(Thread.currentThread().getName() + " -> 成功获取锁，lock节点：[" + lockID + "]");
                return true;
            }
            SortedSet<String> lessThanLockId = ((TreeSet<String>) sortedSet).headSet(lockID);
            if (lessThanLockId != null && lessThanLockId.isEmpty()) {
                String preLockID = lessThanLockId.last();
//                this.lockID = preLockID;
                zooKeeper.exists(preLockID, new LockWatcher(countDownLatch));
                countDownLatch.await(sessionTimeout, TimeUnit.MILLISECONDS);
                //上面这段代码意味着如果会话超时或者被删除了
                System.out.println(Thread.currentThread().getName() + " -> 成功获取锁，节点id：[" + preLockID + "]");
            }
            return true;

        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public  boolean unlock() {
        System.out.println(Thread.currentThread().getName() + " -> 开始释放锁：[" + lockID + "]");
        try {
            zooKeeper.delete(lockID, -1);
            System.out.println("节点：" + lockID + "释放成功");
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                DistributeLock_javapai distributeLock = null;
                try {
                    distributeLock = new DistributeLock_javapai();
                    latch.countDown();
                    latch.await();
                    distributeLock.lock();
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (distributeLock != null) {
                        distributeLock.unlock();
                    }
                }
            }).start();
        }
    }
}
