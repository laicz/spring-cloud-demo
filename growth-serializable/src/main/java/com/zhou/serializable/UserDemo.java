/**
 * Date:     2018/8/1216:01
 * AUTHOR:   Administrator
 */
package com.zhou.serializable;

import com.zhou.bean.User;

import java.io.*;

/**
 * 2018/8/12  16:01
 * created by zhoumb
 */
public class UserDemo {
    public static void main(String[] args) {
        serializable();
        User user = deSerializable();
        System.out.println(user);

    }

    public static void serializable() {
        try {
            User user = new User();
            user.setName("parent field");
            user.setAddress("owe field");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("user")));
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User deSerializable() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("user")));
            return (User) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
