/**
 * Date:     2018/10/716:33
 * AUTHOR:   Administrator
 */
package com.zhou.activemq.test_1;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 2018/10/7  16:33
 * created by zhoumb
 */
public class QueueReciver {
    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://60.205.176.135:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("my-queue");

        MessageConsumer consumer = session.createConsumer(destination);
        for (int i = 0; i < 3; i++) {
            //receive是同步消息消息的  没有消息的话会一直阻塞
            TextMessage receive = (TextMessage) consumer.receive();
            session.commit();
            System.out.println("接受到的结果：" + receive.getText());
        }
        session.close();
        connection.close();
    }
}
