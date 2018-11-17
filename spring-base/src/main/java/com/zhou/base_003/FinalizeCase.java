/**
 * Date:     2018/11/1522:31
 * AUTHOR:   Administrator
 */
package com.zhou.base_003;

import java.util.concurrent.TimeUnit;

/**
 * finalize 方法的案例
 * 2018/11/15  22:31
 * created by zhoumb
 */
public class FinalizeCase {

    private static Block block = null;

    public static void main(String[] args) throws InterruptedException {
        block = new Block();
        TimeUnit.SECONDS.sleep(5);
        block = null;
        System.gc();
        System.out.println("------------------>>>>>gc");
        TimeUnit.SECONDS.sleep(5);
    }

    static class Block {
        //声明一个200M的内存
        byte[] _200M = new byte[200 * 1024 * 1024];
    }
}
