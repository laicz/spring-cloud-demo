/**
 * Date:     2018/10/2420:23
 * AUTHOR:   Administrator
 */
package com.zhou.mode_002_observer.injava;

/**
 * 2018/10/24  20:23
 * created by zhoumb
 */
public class DisplayWeather {
    public static void main(String[] args) {
        //Subject
        WeatherData weatherData = new WeatherData();

        ConcurrentCondition concurrentCondition = new ConcurrentCondition();
        ForcastCondition forcastCondition = new ForcastCondition();

        weatherData.addObserver(concurrentCondition);
        weatherData.addObserver(forcastCondition);

        weatherData.setData(11,11,11);
        weatherData.setData(1122,1122,1122);

    }
}
