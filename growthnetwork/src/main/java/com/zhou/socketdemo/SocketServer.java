/**
 * Date:     2018/8/1116:15
 * AUTHOR:   Administrator
 */
package com.zhou.socketdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 2018/8/11  16:15
 * created by zhoumb
 */
public class SocketServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(8888);//启动一个服务
            Socket accept = serverSocket.accept();//等待一个请求

            //接收发送的数据
            InputStream inputStream = accept.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            System.out.println(reader.readLine());
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
