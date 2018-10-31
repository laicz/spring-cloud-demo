/**
 * Date:     2018/10/3121:28
 * AUTHOR:   Administrator
 */
package com.zhou.mode_016_builder.use_mode1;

/**
 * 抽象的复杂对象生成器
 * 2018/10/31  21:28
 * created by zhoumb
 */
public abstract class AbsBuilder {
    protected Vacation vacation;

    public AbsBuilder(String std) {
        this.vacation = new Vacation(std);
    }

    /**
     * 构建一批抽象方法，用于创建复杂对象
     */
    abstract Vacation buildVacation();

    abstract void buildDay();

    abstract void addHotel(String hotel);

    abstract void addTicket(String tocket);


}
