/**
 * Date:     2018/8/1116:21
 * AUTHOR:   Administrator
 */
package com.zhou.socketdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 2018/8/11  16:21
 * created by zhoumb
 */
public class SocketClient {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 8888);

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.write("Hello Socket");
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
