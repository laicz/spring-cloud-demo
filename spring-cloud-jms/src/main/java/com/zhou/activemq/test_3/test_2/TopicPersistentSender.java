/**
 * Date:     2018/10/1022:28
 * AUTHOR:   Administrator
 */
package com.zhou.activemq.test_3.test_2;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 非持久化的topic消息  只有消费者处于激活状态才会进行消费  不然会造成消息的丢失
 * 2018/10/10  22:28
 * created by zhoumb
 */
public class TopicPersistentSender {
    public static void main(String[] args) throws Exception {
        //连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://60.205.176.135:61616");
        Connection connection = connectionFactory.createConnection();

        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("my-topic-persistent");
        MessageProducer producer = session.createProducer(topic);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        connection.start();
        for (int i = 0; i < 3; i++) {
            TextMessage textMessage = session.createTextMessage("topic-message:" + i);
            producer.send(textMessage);
        }
        session.close();
        connection.close();
    }
}
