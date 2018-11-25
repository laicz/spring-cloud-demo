/**
 * Date:     2018/11/2517:05
 * AUTHOR:   Administrator
 */
package com.zhou.base_010_concurrent;

import java.lang.management.ThreadInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 非典型的semaphore的用法
 * 2018/11/25  17:05
 * created by zhoumb
 */
public class AbnormalSemaphoreSample {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        for (int i = 0; i < 10; i++) {
            new Thread(new MyWorker(semaphore)).start();
        }
        log("Action...Go!");
        semaphore.release();
        log("Wait for permits off");
        while (semaphore.availablePermits() != 0) {
            TimeUnit.SECONDS.sleep(1);
        }
        log("Action... Go again!");
        semaphore.release(5);
    }

    static class MyWorker implements Runnable {
        private Semaphore semaphore;

        public MyWorker(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                log("Executed!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    private static void log(String msg) {
        String name = Thread.currentThread().getName();
        if (name == null) {
            name = Thread.currentThread().getName();
        }
        System.out.println("【" + simpleDateFormat.format(new Date()) + "】" + name + " " + msg);
    }
}
