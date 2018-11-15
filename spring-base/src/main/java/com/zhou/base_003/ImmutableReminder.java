/**
 * Date:     2018/11/1522:07
 * AUTHOR:   Administrator
 */
package com.zhou.base_003;

import java.util.Date;

/**
 * 创建一个不可变类
 * <p>
 *     Immutable对象的特点：
 * ①：Immutable对象的状态在创建之后就不能发生改变，任何对它的改变都应该产生一个新的对象
 * ②：Immutable对象的属性应该都是final的
 * ③：对象必须被正确的创建，比如：对象引用在对象创建过程中不能泄露
 * ④：对象时final的。以此来限制子类继承父类，避免子类改变父类的Immutable特性
 * ⑤：如果类中包含Immutable对象，则给客户端返回的时候，需要返回这个对象的拷贝，而不是这个对象
 * Immutable类的好处
 * ①：Immutable对象时线程安全的
 * ②：Immutable对象简化了程序的开发，无需锁机制就可以在线程间共享
 * ③：Immutable对象提高了程序的性能，它减少了synchronized的使用
 * ④：Immutable对象可以被重复使用，你可以将它缓存起来
 * 2018/11/15  22:07
 * created by zhoumb
 */
public class ImmutableReminder {
    private final String name;

    private final Date remindingDate;

    public ImmutableReminder(String name, Date remindingDate) {
        this.name = name;
        this.remindingDate = remindingDate;
    }

    /**
     * 因为name本来就是Immutable，因此返回的时候可以直接返回这个对象
     */
    public String getName() {
        return name;
    }

    /**
     * Date对象虽然是final修饰的  但是它的值还是可以被改变，因此返回这个对象的副本（拷贝）
     *
     * @return
     */
    public Date getRemindingDate() {
        return (Date) remindingDate.clone();
    }
}
