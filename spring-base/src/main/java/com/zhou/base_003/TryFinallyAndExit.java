/**
 * Date:     2018/11/1519:57
 * AUTHOR:   Administrator
 */
package com.zhou.base_003;


import com.google.common.collect.ImmutableMap;

/**
 * 使用try finally 和 exit一起使用
 * 2018/11/15  19:57
 * created by zhoumb
 */
public class TryFinallyAndExit {
    public static void main(String[] args) {
        try {
            System.exit(0);
            ImmutableMap<Object, Object> of = ImmutableMap.of();
        } finally {
            //使用System.exit(status)  finally中的代码不会执行
            System.out.println("Print from finally");
        }
    }
}
