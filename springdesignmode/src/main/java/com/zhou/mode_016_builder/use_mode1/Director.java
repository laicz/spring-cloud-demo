/**
 * Date:     2018/10/3121:36
 * AUTHOR:   Administrator
 */
package com.zhou.mode_016_builder.use_mode1;

/**
 * 暴露给外部使用
 * 2018/10/31  21:36
 * created by zhoumb
 */
public class Director {
    private AbsBuilder builder;

    public Director(AbsBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(AbsBuilder builder) {
        this.builder = builder;
    }

    public Vacation getVacation() {
        return this.builder.buildVacation();
    }
}
