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

        serializable();
//        deSerializable();
    }

    //序列化操作
    public static void serializable() throws IOException, ClassNotFoundException {

        Person person = new Person();
//        person.setAge(18);
        person.setName("周");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("person")));
        objectOutputStream.writeObject(person);
        objectOutputStream.flush();

        objectOutputStream.writeObject(person);
        objectOutputStream.flush();

        Person person1 = new Person();
        person1.setName("new name ");
        person1.setAddress("new Address");
        person1.setHeight(123);
        objectOutputStream.writeObject(person1);
        objectOutputStream.flush();

        objectOutputStream.close();

        System.out.println(new File("person").length());

        System.out.println("序列化成功");

        System.out.println("开始反序列化");
        //第一次
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("person")));
        Person dePerson1 = (Person) objectInputStream.readObject();
        System.out.println("第一序列化：" + dePerson1);
        Person dePerson2 = (Person) objectInputStream.readObject();
        System.out.println("第一序列化：" + dePerson2);
        Person dePerson3 = (Person) objectInputStream.readObject();
        System.out.println("第一序列化：" + dePerson3);

        /**
         * 如果多次序列化  将会导致异常EOFException
         */
        /*Person dePerson4 = (Person) objectInputStream.readObject();
        System.out.println("第一序列化：" + dePerson4);*/

        objectInputStream.close();
    }

    //反序列化操作
    public static void deSerializable() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("person")));
        Person person = (Person) objectInputStream.readObject();
        System.out.println(person);
    }
}
