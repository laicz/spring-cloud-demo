/**
 * Date:     2018/10/2122:04
 * AUTHOR:   Administrator
 */
package com.zhou.mode_002_observer.mode;

/**
 * 2018/10/21  22:04
 * created by zhoumb
 */
public class CurrentConditions implements Observer {
    private float temperature;
    private float pressure;
    private float humidity;

    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("temperature:" + temperature + ", pressure:" + pressure + " , humidity:" + humidity);
    }
}
