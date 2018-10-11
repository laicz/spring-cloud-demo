/**
 * Date:     2018/10/1122:48
 * AUTHOR:   Administrator
 */
package com.zhou.activemq.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.UnsupportedEncodingException;

/**
 * 持久订阅消费者
 * 2018/10/11  22:48
 * created by zhoumb
 */
public class DurableTopicConsumer implements MessageListener {
    @Override
    public void onMessage(Message message) {
        byte[] body = message.getBody();
        try {
            System.out.println(new String(body, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
