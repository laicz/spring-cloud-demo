/**
 * Date:     2018/10/2122:08
 * AUTHOR:   Administrator
 */
package com.zhou.mode_002_observer.mode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 温度数据是被观察的目标
 * 2018/10/21  22:08
 * created by zhoumb
 */
public class WeatherDataSt implements Subject {
    private float temperature;
    private float pressure;
    private float humidity;

    //需要一个集合保存观察者
    private ArrayList<Observer> observers = Lists.newArrayList();

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    @Override
    public void registerObserver(Observer observer) {
        if (observers.contains(observer)) {
            return;
        }
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        observers.stream().forEach(observer -> {
            observer.update(getTemperature(), getPressure(), getHumidity());
        });
    }
}
