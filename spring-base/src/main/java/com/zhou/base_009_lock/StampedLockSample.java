/**
 * Date:     2018/11/2222:36
 * AUTHOR:   Administrator
 */
package com.zhou.base_009_lock;

import java.util.concurrent.locks.StampedLock;

/**
 * 因为ReentrantReadWriteLock表现的也不是在太好，因此在1.8引入了StampedLock
 * 2018/11/22  22:36
 * created by zhoumb
 */
public class StampedLockSample {
    private final StampedLock stampedLock = new StampedLock();

    void mutate() {
        long stamp = stampedLock.writeLock();
        try {

        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    void read() {
        long stamp = stampedLock.readLock();
        try {
            // do something
        } finally {
            stampedLock.unlockRead(stamp);
        }
    }

}
