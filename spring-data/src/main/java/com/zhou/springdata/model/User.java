/**
 * Date:     2018/9/1620:28
 * AUTHOR:   Administrator
 */
package com.zhou.springdata.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * 2018/9/16  20:28
 * created by zhoumb
 */
@Document
public class User {
    @Id
    private String id;
    private String userName;
    private String sex;
    private String age;
    private String attribute;
    @Indexed(background = true,sparse = true)
    private Date ctime;

    public User() {
    }

    public User(String id, String userName, String sex, String age, String attribute,Date ctime) {
        this.id = id;
        this.userName = userName;
        this.sex = sex;
        this.age = age;
        this.attribute = attribute;
        this.ctime = ctime;
    }

    public User(String userName, String sex, String age, String attribute,Date ctime) {
        this.userName = userName;
        this.sex = sex;
        this.age = age;
        this.attribute = attribute;
        this.ctime = ctime;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}
