/**
 * Date:     2018/11/221:25
 * AUTHOR:   Administrator
 */
package com.zhou.mode_019_Interpreter.use_mode;

/**
 * 符号表达式超类
 * 2018/11/2  21:25
 * created by zhoumb
 */
public abstract class SymbolExpression extends AbstractExpression {
    protected AbstractExpression left;
    protected AbstractExpression right;

    public SymbolExpression(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }
}
