/**
 * Date:     2018/11/221:32
 * AUTHOR:   Administrator
 */
package com.zhou.mode_019_Interpreter.use_mode;

import java.util.HashMap;

/**
 * 2018/11/2  21:32
 * created by zhoumb
 */
public class SubExpression extends SymbolExpression {
    public SubExpression(AbstractExpression left, AbstractExpression right) {
        super(left, right);
    }

    @Override
    Float interpreter(HashMap<String, Float> var) {
        return super.left.interpreter(var) - super.right.interpreter(var);
    }
}
