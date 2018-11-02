/**
 * Date:     2018/11/221:33
 * AUTHOR:   Administrator
 */
package com.zhou.mode_019_Interpreter.use_mode;

import java.util.HashMap;

/**
 * 2018/11/2  21:33
 * created by zhoumb
 */
public class DivExpression extends SymbolExpression {
    public DivExpression(AbstractExpression left, AbstractExpression right) {
        super(left, right);
    }

    @Override
    Float interpreter(HashMap<String, Float> var) {
        return super.left.interpreter(var) / super.right.interpreter(var);
    }
}
