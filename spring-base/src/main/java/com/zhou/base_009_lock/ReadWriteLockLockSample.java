/**
 * Date:     2018/11/2221:58
 * AUTHOR:   Administrator
 */
package com.zhou.base_009_lock;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 2018/11/22  21:58
 * created by zhoumb
 */
public class ReadWriteLockLockSample {
    private final Map<String, String> m = new TreeMap<>();
    private final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = reentrantReadWriteLock.readLock();
    private final Lock writeLock = reentrantReadWriteLock.writeLock();

    public String get(String key) {
        readLock.lock();
        System.out.println("读锁锁定！");
        try {
            return m.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public String put(String key, String entry) {
        writeLock.lock();
        System.out.println("写锁锁定！");
        try {
            return m.put(key, entry);
        } finally {
            writeLock.unlock();
        }
    }
}
