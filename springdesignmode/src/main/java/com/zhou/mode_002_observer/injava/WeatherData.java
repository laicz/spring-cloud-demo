/**
 * Date:     2018/10/2223:12
 * AUTHOR:   Administrator
 */
package com.zhou.mode_002_observer.injava;

import com.google.common.collect.ImmutableMap;

import java.util.Observable;

/**
 * 使用java内置的观察者模式
 * 2018/10/22  23:12
 * created by zhoumb
 */
public class WeatherData extends Observable {
    private float humidity;
    private float pressure;
    private float temperature;

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void setData(float humidity, float pressure, float temperature) {
        this.humidity = humidity;
        this.pressure = pressure;
        this.temperature = temperature;
        //使用java内置的观察者模式
        this.setChanged();//一定要设置变化
        this.notifyObservers(ImmutableMap.of("humidity", humidity, "pressure", pressure, "temperature", temperature));
    }
}
