/**
 * Date:     2018/10/3121:33
 * AUTHOR:   Administrator
 */
package com.zhou.mode_016_builder.use_mode1;

/**
 * 这是具体的构建类，根据对象的不同来实现不同的构建者
 * 2018/10/31  21:33
 * created by zhoumb
 */
public class ConcreateBuilder extends AbsBuilder {
    public ConcreateBuilder(String std) {
        super(std);
    }

    @Override
    Vacation buildVacation() {
        buildDay();
        addHotel("");
        addTicket("");
        return vacation;
    }

    @Override
    void buildDay() {

    }

    @Override
    void addHotel(String hotel) {

    }

    @Override
    void addTicket(String tocket) {

    }
}
