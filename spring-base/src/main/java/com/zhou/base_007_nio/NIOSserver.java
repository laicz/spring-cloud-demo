/**
 * Date:     2018/11/2023:05
 * AUTHOR:   Administrator
 */
package com.zhou.base_007_nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Set;

/**
 * 2018/11/20  23:05
 * created by zhoumb
 */
public class NIOSserver extends Thread {

    @Override
    public void run() {
        try {
            //启用一个多路复用器
            Selector selector = Selector.open();
            //开启一个通道
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
            //明确设置为非阻塞模式，在阻塞模式下，注册操作是不允许的，会抛出IllegalBlockingModeException
            channel.configureBlocking(false);
            //将时间通道上的时间注册到多路复用器上
            channel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                selector.select();//阻塞等待等待就绪的通道
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for (SelectionKey selectionKey : selectionKeys) {
                    ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel client = server.accept();
                    client.write(Charset.defaultCharset().encode("Hello World!"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
