/**
 * Date:     2018/11/221:19
 * AUTHOR:   Administrator
 */
package com.zhou.mode_019_Interpreter.use_mode;

import java.util.HashMap;

/**
 * 抽象表达式  所有的运算表达式的超类
 * 2018/11/2  21:19
 * created by zhoumb
 */
public abstract class AbstractExpression {
    abstract Float interpreter(HashMap<String, Float> var);
}
