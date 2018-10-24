/**
 * Date:     2018/10/2122:02
 * AUTHOR:   Administrator
 */
package com.zhou.mode_002_observer.mode;

/**
 * 主题(被观察者)
 * 2018/10/21  22:02
 * created by zhoumb
 */
public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
