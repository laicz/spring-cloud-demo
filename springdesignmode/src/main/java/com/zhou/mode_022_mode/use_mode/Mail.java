/**
 * Date:     2018/11/310:45
 * AUTHOR:   Administrator
 */
package com.zhou.mode_022_mode.use_mode;

/**
 * 邮件对象
 * 2018/11/3  10:45
 * created by zhoumb
 */
public class Mail implements Cloneable {
    private String receiver;
    private String subject;
    private String content;
    private String tail;

    public Mail(EventTemplate eventTemplate) {
        this.tail = eventTemplate.getEventContent();
        this.subject = eventTemplate.getEventSubject();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    @Override
    protected Mail clone() throws CloneNotSupportedException {
        return (Mail) super.clone();
    }
}
