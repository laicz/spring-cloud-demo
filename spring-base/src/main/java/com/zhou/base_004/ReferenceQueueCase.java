/**
 * Date:     2018/11/1716:40
 * AUTHOR:   Administrator
 */
package com.zhou.base_004;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 引用队列的案例
 * <p>
 * 如果我们需要知道一个对象被gc后需要做其他的额外操作，则需要一个ReferenceQueue这个队列
 * 一个对象被GC后，其相应的包装类将会被放置到当时的queue中，我们可以从queue中获取到这个数据，进行其他的额外操作
 * 2018/11/17  16:40
 * created by zhoumb
 */
public class ReferenceQueueCase {
    public static void main(String[] args) {
//        referenceStart();
        softReferenceQueue();
    }

    private static void softReferenceQueue() {
        final ReferenceQueue referenceQueue = new ReferenceQueue();

        int _1M = 1024 * 1024;
        Object value = new Object();
        final Map<SoftReference, Object> map = new HashMap<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Reference remove;
                    while ((remove = referenceQueue.remove()) != null) {
                        //可以使用这个将集合中被垃圾回收的对象给清除，不然集合对象中实际存在的对象跟size是不相等的
                        map.remove(remove);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        for (int i = 0; i < 20000; i++) {
            byte[] bytes = new byte[_1M];
            SoftReference softReference = new SoftReference(bytes, referenceQueue);
            map.put(softReference, value);
        }
        System.out.println(map.size());
    }

    private static void referenceStart() {
        Object counter = new Object();
        ReferenceQueue referenceQueue = new ReferenceQueue();

        PhantomReference<Object> phantomReference = new PhantomReference<>(counter, referenceQueue);

        SoftReference<String> softReference = new SoftReference<>("softReference", referenceQueue);

        counter = null;
        System.gc();
        while (true) {
            try {
                Reference ref = referenceQueue.remove(1000L);
                if (ref != null) {
                    System.out.println(ref);
                }
                TimeUnit.SECONDS.sleep(3L);
            } catch (InterruptedException e) {

            }
        }
    }
}
