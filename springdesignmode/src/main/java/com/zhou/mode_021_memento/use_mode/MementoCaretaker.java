/**
 * Date:     2018/11/310:06
 * AUTHOR:   Administrator
 */
package com.zhou.mode_021_memento.use_mode;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 备忘录管理者
 * 2018/11/3  10:06
 * created by zhoumb
 */
public class MementoCaretaker {
    private Map<String, MementoIF> mementoIFMap;

    public MementoCaretaker() {
        mementoIFMap = Maps.newHashMap();
    }

    public MementoIF retrieveMemento(String name) {
        return mementoIFMap.get(name);
    }

    /**
     * 添加备忘录
     * @param name
     * @param mementoIF
     */
    public void saveMemento(String name, MementoIF mementoIF) {
        this.mementoIFMap.put(name, mementoIF);
    }
}
