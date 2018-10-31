/**
 * Date:     2018/10/3121:11
 * AUTHOR:   Administrator
 */
package com.zhou.mode_016_builder.use_mode1;

import com.google.common.collect.Lists;

import java.util.Date;
import java.util.List;

/**
 * 每一个度假天都是一个组成度假的部分
 * 2018/10/31  21:11
 * created by zhoumb
 */
public class VacationDay {
    private Date date;
    private String hotel;
    private List<String> tickets;
    private List<String> events;

    public VacationDay(Date date) {
        this.date = date;
        tickets = Lists.newArrayList();
        events = Lists.newArrayList();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public List<String> getTickets() {
        return tickets;
    }

    public void setTickets(List<String> tickets) {
        this.tickets = tickets;
    }

    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }

    public String showInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Date:" + date.toString()).append("\n");
        info.append("Hotel:" + hotel).append("\n");
        info.append("Tickets:" + tickets.toString()).append("\n");
        info.append("Events:" + events.toString()).append("\n");
        return info.toString();
    }
}
