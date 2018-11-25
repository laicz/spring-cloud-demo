/**
 * Date:     2018/11/2521:31
 * AUTHOR:   Administrator
 */
package com.zhou.base_010_concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier使用案例
 * 当指定数量的线程数都达到await，CyclicBarrier中指定的线程才会往下执行
 * 2018/11/25  21:31
 * created by zhoumb
 */
public class CyclicBarrierSample {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("Action... Go again!");
            }
        });
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new CyclicWorker(cyclicBarrier));
            thread.start();
        }
        System.out.println("Action...Go ahead");
    }

    private static class CyclicWorker implements Runnable {
        private CyclicBarrier cyclicBarrier;

        public CyclicWorker(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("Executed!");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
