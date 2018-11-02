/**
 * Date:     2018/11/221:37
 * AUTHOR:   Administrator
 */
package com.zhou.mode_019_Interpreter.use_mode;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 逆波兰表达式
 * 2018/11/2  21:37
 * created by zhoumb
 */
public class RPN {
    private List<String> expression = Lists.newArrayList();
    private List<String> right = Lists.newArrayList();

    private AbstractExpression result;//结果

    //根据输入信息创建对象，将数字与发哦莝夫放入ArrayList中

    public RPN(List<String> expression) {
        this.expression = expression;
    }
}
