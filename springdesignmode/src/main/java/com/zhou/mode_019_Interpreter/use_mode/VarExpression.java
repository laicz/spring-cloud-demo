/**
 * Date:     2018/11/221:22
 * AUTHOR:   Administrator
 */
package com.zhou.mode_019_Interpreter.use_mode;

import java.util.HashMap;

/**
 * 2018/11/2  21:22
 * created by zhoumb
 */
public class VarExpression extends AbstractExpression {
    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    Float interpreter(HashMap<String, Float> var) {
        return var.get(this.key);
    }
}
