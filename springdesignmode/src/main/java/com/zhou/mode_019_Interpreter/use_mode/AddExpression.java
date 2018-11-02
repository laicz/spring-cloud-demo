/**
 * Date:     2018/11/221:31
 * AUTHOR:   Administrator
 */
package com.zhou.mode_019_Interpreter.use_mode;

import java.util.HashMap;

/**
 * 2018/11/2  21:31
 * created by zhoumb
 */
public class AddExpression extends SymbolExpression {
    public AddExpression(AbstractExpression left, AbstractExpression right) {
        super(left, right);
    }

    @Override
    Float interpreter(HashMap<String, Float> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}
