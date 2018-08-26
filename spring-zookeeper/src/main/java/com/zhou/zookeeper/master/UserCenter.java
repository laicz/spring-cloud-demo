/**
 * Date:     2018/8/269:45
 * AUTHOR:   Administrator
 */
package com.zhou.zookeeper.master;

import java.io.Serializable;

/**
 * 用户中心
 * 2018/8/26  9:45
 * created by zhoumb
 */
public class UserCenter implements Serializable {
    private int mc_id;//机器信息
    private String mc_name;//机器名称

    public int getMc_id() {
        return mc_id;
    }

    public void setMc_id(int mc_id) {
        this.mc_id = mc_id;
    }

    public String getMc_name() {
        return mc_name;
    }

    public void setMc_name(String mc_name) {
        this.mc_name = mc_name;
    }
}
