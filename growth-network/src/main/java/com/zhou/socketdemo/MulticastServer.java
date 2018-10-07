/**
 * Date:     2018/8/1122:36
 * AUTHOR:   Administrator
 */
package com.zhou.socketdemo;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.concurrent.TimeUnit;

/**
 * 使用组播协议
 * 2018/8/11  22:36
 * created by zhoumb
 */
public class MulticastServer {

    public static void main(String[] args) {
        try {
            //地址段：224.0.0.0 - 239.255.255.255
            InetAddress group = InetAddress.getByName("224.5.6.7");

            MulticastSocket multicastSocket = new MulticastSocket();

            for (int i = 0; i < 10; i++) {
                String data = "Hello Mic";
                byte[] bytes = data.getBytes();
                multicastSocket.send(new DatagramPacket(bytes, bytes.length, group, 8888));
                TimeUnit.SECONDS.sleep(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
