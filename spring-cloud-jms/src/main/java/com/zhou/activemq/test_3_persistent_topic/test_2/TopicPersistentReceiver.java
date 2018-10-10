/**
 * Date:     2018/10/1022:33
 * AUTHOR:   Administrator
 */
package com.zhou.activemq.test_3_persistent_topic.test_2;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 一定要先运行一次  向服务端注册一个订阅者
 * 2018/10/10  22:33
 * created by zhoumb
 */
public class TopicPersistentReceiver {
    public static void main(String[] args) throws Exception {
        //连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://60.205.176.135:61616");
        Connection connection = connectionFactory.createConnection();
        connection.setClientID("cc1");

        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("my-topic-persistent");
        TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic, "T1");
        connection.start();

/*        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("my-topic-persistent");
        MessageConsumer consumer = session.createConsumer(topic);*/
        while (true) {
            TextMessage textMessage = (TextMessage) topicSubscriber.receive();
            System.out.println("接收到的消息：" + textMessage.getText());
        }
       /* session.close();
        connection.close();*/
    }
}
