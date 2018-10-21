/**
 * Date:     2018/10/2110:03
 * AUTHOR:   Administrator
 */
package com.zhou.mode_002_observer.oo;

/**
 * ①：提供温度，气压和湿度的接口
 * ②：测量的数据跟新时需要通知给第三方
 * ③：需要设计开放性API，便于第三方公司接入
 * 2018/10/21  10:03
 * created by zhoumb
 */
public class WeatherData {
    private float temperature;
    private float pressure;
    private float humidity;
    //气温变化需要通知展示板
    private CurrentConditions currentConditions;

    public WeatherData() {
    }

    public WeatherData(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
    }

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

    public void dataChange() {
        currentConditions.update(this.temperature, this.pressure, this.humidity);
    }

    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        dataChange();
    }
}
