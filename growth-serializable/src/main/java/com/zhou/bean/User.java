/**
 * Date:     2018/8/1215:21
 * AUTHOR:   Administrator
 */
package com.zhou.bean;

/**
 * 子类继承父类  父类实现了serializable，子类的的属性也会被序列化
 * 2018/8/12  15:21
 * created by zhoumb
 */
public class User extends SuperUser {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "address='" + address + '\'' +
                "name='" + name + '\'' +
                '}';
    }
}
