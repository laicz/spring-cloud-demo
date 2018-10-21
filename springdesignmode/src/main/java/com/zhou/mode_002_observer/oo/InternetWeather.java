/**
 * Date:     2018/10/2110:20
 * AUTHOR:   Administrator
 */
package com.zhou.mode_002_observer.oo;

/**
 * 2018/10/21  10:20
 * created by zhoumb
 */
public class InternetWeather {
    public static void main(String[] args) {
        CurrentConditions currentConditions = new CurrentConditions();
        WeatherData weatherData = new WeatherData(currentConditions);
        weatherData.setData(2.4F, 22F, 12.3F);
    }
}
