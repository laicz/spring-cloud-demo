/**
 * Date:     2018/11/2223:05
 * AUTHOR:   Administrator
 */
package com.zhou.base_009_lock;

import com.alibaba.fastjson.JSON;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 检测死锁
 * 2018/11/22  23:05
 * created by zhoumb
 */
public class ThreadMXBeanSample {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
                ThreadInfo[] threadInfo = threadMXBean.getThreadInfo(deadlockedThreads);
                if (deadlockedThreads != null) {
                    System.out.println("detected deadlock threads:");
                    for (ThreadInfo threadInfo1 :
                            threadInfo) {
                        System.out.println(JSON.toJSONString(threadInfo));
                    }
                }
            }
        }, 5L, SECONDS);
    }
}
