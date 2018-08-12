/**
 * Date:     2018/8/1123:57
 * AUTHOR:   Administrator
 */
package com.zhou.serializable;

import com.zhou.bean.Person;

import java.io.*;

/**
 * 2018/8/11  23:57
 * created by zhoumb
 */
public class SerializableDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        serializable();
        deSerializable();
    }

    //序列化操作
    public static void serializable() throws IOException {

        Person person = new Person();
//        person.setAge(18);
        person.setName("周");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("person")));
        objectOutputStream.writeObject(person);
        objectOutputStream.close();

        System.out.println("序列化成功");
    }

    //反序列化操作
    public static void deSerializable() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("person")));
        Person person = (Person) objectInputStream.readObject();
        System.out.println(person);
    }
}
