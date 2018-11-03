/**
 * Date:     2018/11/310:44
 * AUTHOR:   Administrator
 */
package com.zhou.mode_022_mode.use_mode;

/**
 * 电子账单时间类型
 * 2018/11/3  10:44
 * created by zhoumb
 */
public class EventTemplate {
    private String eventSubject, eventContent;

    public EventTemplate(String eventSubject, String eventContent) {
        this.eventSubject = eventSubject;
        this.eventContent = eventContent;
    }

    public String getEventSubject() {
        return eventSubject;
    }

    public void setEventSubject(String eventSubject) {
        this.eventSubject = eventSubject;
    }

    public String getEventContent() {
        return eventContent;
    }

    public void setEventContent(String eventContent) {
        this.eventContent = eventContent;
    }
}
