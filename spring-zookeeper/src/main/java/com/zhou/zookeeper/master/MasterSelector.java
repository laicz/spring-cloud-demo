/**
 * Date:     2018/8/269:47
 * AUTHOR:   Administrator
 */
package com.zhou.zookeeper.master;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * master选举类
 * <p>
 * 选主的服务
 * </p>
 * 2018/8/26  9:47
 * created by zhoumb
 */
public class MasterSelector {
    private ZkClient zkClient;
    private final static String MASTER_PATH = "/master";//需要争抢的节点
    private IZkDataListener dataListener;//注册内容变化
    private UserCenter server;
    private UserCenter master;
    private static boolean isRunning = false;

    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    public MasterSelector(UserCenter server) {
        this.server = server;
        this.dataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {

            }
        };
    }

    public void start() {
        //开始选举
        if (!isRunning) {
            isRunning = true;
            zkClient.subscribeDataChanges(MASTER_PATH, dataListener);//注册节点事件
            chooseMaster();
        }
    }

    public void stop() {
        //停止
        if (isRunning) {
            isRunning = false;
            zkClient.unsubscribeDataChanges(MASTER_PATH, dataListener);
            releaseMaster();
        }
    }

    //开始进行选举
    public void chooseMaster() {
        if (!isRunning) {
            System.out.println("当前服务没有启动");
            return;
        }
        try {
            zkClient.createEphemeral(MASTER_PATH, server);
            master = server;
            System.out.println(master.getMc_name() + " -> 我已经是master了");

            //master释放
            executorService.schedule(() -> {
                releaseMaster();
            }, 5, TimeUnit.SECONDS);
        } catch (Exception e) {
            //表示master已经存在
            UserCenter userCenter = zkClient.readData(MASTER_PATH, true);
            if (userCenter == null) {
                chooseMaster();
            } else {
                master = userCenter;
            }
        }
    }

    //释放锁
    public void releaseMaster() {
        //判断当前是否master
        if (checkMaster()) {
            zkClient.deleteRecursive(MASTER_PATH);
        }
    }

    //判断当前服务器是否是master
    public boolean checkMaster() {
        UserCenter userCenter = zkClient.readData(MASTER_PATH);
        if (userCenter.getMc_name().equals(server.getMc_name())) {
            master = userCenter;
            return true;
        }
        return false;
    }
}
