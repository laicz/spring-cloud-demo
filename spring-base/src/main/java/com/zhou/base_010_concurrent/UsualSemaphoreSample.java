/**
 * Date:     2018/11/2516:39
 * AUTHOR:   Administrator
 */
package com.zhou.base_010_concurrent;

import java.lang.management.ThreadInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 使用Semaphore案例
 *
 * semaphore能保证最多能有指定数量的线程使用指定的资源
 * 如果超过了  则其他的线程需要等待  如果有某一个释放  其他的等待的线程可以立即去获取
 * 2018/11/25  16:39
 * created by zhoumb
 */
public class UsualSemaphoreSample {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        System.out.println("Action... Go!");
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            new Thread(new SemaphoreWorker(semaphore)).start();
        }
    }

    static class SemaphoreWorker implements Runnable {
        private String name;
        private Semaphore semaphore;

        public SemaphoreWorker(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                log("is waiting for a permit");
                semaphore.acquire();
                log("acquirede a permit!");
                log("executed!");
                TimeUnit.SECONDS.sleep(new Random().nextInt(15));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                log("released a permit!");
                semaphore.release();
            }
        }

        private void log(String msg) {
            if (name == null) {
                name = Thread.currentThread().getName();
            }
            System.out.println("【" + simpleDateFormat.format(new Date()) + "】" + name + " " + msg);
        }
    }
}
