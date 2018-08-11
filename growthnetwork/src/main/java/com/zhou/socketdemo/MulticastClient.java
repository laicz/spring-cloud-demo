/**
 * Date:     2018/8/1122:46
 * AUTHOR:   Administrator
 */
package com.zhou.socketdemo;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * 2018/8/11  22:46
 * created by zhoumb
 */
public class MulticastClient {

    public static void main(String[] args) {

        try {
            InetAddress group = InetAddress.getByName("224.5.6.7");
            MulticastSocket multicastSocket = new MulticastSocket(8888);
            multicastSocket.joinGroup(group);

            byte[] buf = new byte[256];
            while (true) {
                DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
                multicastSocket.receive(datagramPacket);

                String msg = new String(datagramPacket.getData());
                System.out.println("接收到的数据：" + msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
