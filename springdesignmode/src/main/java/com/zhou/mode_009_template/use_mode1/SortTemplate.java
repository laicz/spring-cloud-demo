/**
 * Date:     2018/10/2821:01
 * AUTHOR:   Administrator
 */
package com.zhou.mode_009_template.use_mode1;

import java.util.Arrays;

/**
 * 2018/10/28  21:01
 * created by zhoumb
 */
public abstract class SortTemplate {
    public final void sort(Object[] objects) {
        for (int i = 0; i < objects.length - 1; i++) {
            if (compare(objects[i++])){
                //swap()
            }else{

            }
        }
    }

    //怎么进行来排序使用子类来进行使用什么维度，什么排序顺序来进行排序
    protected abstract boolean compare(Object object);

}
