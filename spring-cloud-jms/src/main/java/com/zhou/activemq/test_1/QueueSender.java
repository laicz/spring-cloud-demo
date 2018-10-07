/**
 * Date:     2018/10/710:37
 * AUTHOR:   Administrator
 */
package com.zhou.activemq.test_1;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.TimeUnit;

/**
 * 2018/10/7  10:37
 * created by zhoumb
 */
public class QueueSender {
    public static void main(String[] args) throws Exception {
        //连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://60.205.176.135:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();

        //true：是否使用事务
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("my-queue");

        MessageProducer producer = session.createProducer(destination);
        for (int i = 0; i < 3; i++) {
            //创建需要发送的消息
            TextMessage textMessage = session.createTextMessage("message--" + i);
//            TimeUnit.SECONDS.sleep(1);
            //通过消息发送者发送消息
            producer.send(textMessage);
        }

        session.commit();
        session.close();
        connection.close();
    }
}
