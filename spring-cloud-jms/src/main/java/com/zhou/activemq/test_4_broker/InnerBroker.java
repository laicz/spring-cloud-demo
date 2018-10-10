/**
 * Date:     2018/10/1023:35
 * AUTHOR:   Administrator
 */
package com.zhou.activemq.test_4_broker;

import org.apache.activemq.broker.BrokerService;

/**
 * 2018/10/10  23:35
 * created by zhoumb
 */
public class InnerBroker {
    public static void main(String[] args) throws Exception {
        //可以启动一个activeMQ实例
        BrokerService broker = new BrokerService();
        broker.setUseJmx(true);
        broker.addConnector("tcp://localhost:61616");
        broker.start();
    }
}
