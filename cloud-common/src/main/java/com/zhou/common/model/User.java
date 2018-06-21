/**
 * Date:     2018/6/2123:04
 * AUTHOR:   Administrator
 */
package com.zhou.common.model;

/**
 * 2018/6/21  23:04
 * created by zhoumb
 */
public class User {

    private String userName;

    private Integer age;

    public User() {
    }

    public User(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
