/**
 * Date:     2018/10/1122:11
 * AUTHOR:   Administrator
 */
package com.zhou.springcloudjms.activemq;

import com.alibaba.fastjson.JSON;
import com.zhou.springcloudjms.SpringCloudJmsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 2018/10/11  22:11
 * created by zhoumb
 */
@ContextConfiguration(locations = {"classpath:spring/spring-root.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringCloudJmsApplication.class)
public class InitActiveMQTest {
    @Autowired
    @Qualifier(value = "jmsQueueTemplate")
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier(value = "jmsTopicTemplate")
    private JmsTemplate jmsTemplate1;

    @Test
    public void init() {
        jmsTemplate.setPriority(9);
        jmsTemplate.send("spring-boot-aggreagtion-active", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("hell,spring activemq");
            }
        });
        System.out.println(JSON.toJSONString(jmsTemplate));
    }

}
