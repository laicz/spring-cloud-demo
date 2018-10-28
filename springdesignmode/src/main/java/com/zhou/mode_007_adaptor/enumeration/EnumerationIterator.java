/**
 * Date:     2018/10/2815:13
 * AUTHOR:   Administrator
 */
package com.zhou.mode_007_adaptor.enumeration;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * 使用适配器模式实现：从枚举器到迭代器的适配
 * 2018/10/28  15:13
 * created by zhoumb
 */
public class EnumerationIterator implements Iterator {
    //拥有被适配的对象
    private Enumeration enumeration;

    public EnumerationIterator(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }
}
