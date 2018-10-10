/**
 * Date:     2018/10/1022:33
 * AUTHOR:   Administrator
 */
package com.zhou.activemq.test_2;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 2018/10/10  22:33
 * created by zhoumb
 */
public class TopicReceiver {
    public static void main(String[] args) throws Exception {
        //连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://60.205.176.135:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("my-topic");
        MessageConsumer consumer = session.createConsumer(topic);
        while (true) {
            TextMessage textMessage = (TextMessage) consumer.receive();
            System.out.println("接收到的消息：" + textMessage.getText());
        }
       /* session.close();
        connection.close();*/
    }
}
