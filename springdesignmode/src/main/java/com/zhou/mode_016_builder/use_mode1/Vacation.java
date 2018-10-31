/**
 * Date:     2018/10/3121:18
 * AUTHOR:   Administrator
 */
package com.zhou.mode_016_builder.use_mode1;

import com.google.common.collect.Lists;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 度假对象(在生成器模式中模拟一个复杂对象)
 * 2018/10/31  21:18
 * created by zhoumb
 */
public class Vacation {
    private List<VacationDay> vacationDays;
    private Date ctime;
    private int days;
    private VacationDay vacationDay;

    public Vacation(String std) {
        vacationDays = Lists.newArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = simpleDateFormat.parse(std);
            this.ctime = parse;
            vacationDay = new VacationDay(parse);
            vacationDays.add(vacationDay);
            days++;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
