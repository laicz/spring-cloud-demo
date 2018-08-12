/**
 * Date:     2018/8/1215:20
 * AUTHOR:   Administrator
 */
package com.zhou.bean;

import java.io.Serializable;

/**
 * 2018/8/12  15:20
 * created by zhoumb
 */
public class SuperUser implements Serializable {
    private static final long serialVersionUID = -4967870390056817272L;

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "name='" + name + '\'' +
                '}';
    }
}
