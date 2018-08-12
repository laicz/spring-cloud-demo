/**
 * Date:     2018/8/1123:50
 * AUTHOR:   Administrator
 */
package com.zhou.bean;

import java.io.Serializable;

/**
 * 2018/8/11  23:50
 * created by zhoumb
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -3037059174409683308L;
    private String name;

//    private int age;

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
