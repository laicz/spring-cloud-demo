/**
 * Date:     2018/11/221:27
 * AUTHOR:   Administrator
 */
package com.zhou.mode_019_Interpreter.use_mode;

import java.util.HashMap;

/**
 * 2018/11/2  21:27
 * created by zhoumb
 */
public class MultiExpression extends SymbolExpression {
    public MultiExpression(AbstractExpression left, AbstractExpression right) {
        super(left, right);
    }

    /**
     *
     * @param var
     * @return
     */
    @Override
    Float interpreter(HashMap<String, Float> var) {
        return super.left.interpreter(var) * super.right.interpreter(var);
    }
}
