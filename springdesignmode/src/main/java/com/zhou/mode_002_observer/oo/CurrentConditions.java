/**
 * Date:     2018/10/2110:07
 * AUTHOR:   Administrator
 */
package com.zhou.mode_002_observer.oo;

/**
 * 2018/10/21  10:07
 * created by zhoumb
 */
public class CurrentConditions {
    private float temperature;
    private float pressure;
    private float humidity;

    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("temperature: " + temperature);
        System.out.println("pressure: " + pressure);
        System.out.println("humidity: " + humidity);
    }
}
