/**
 * Date:     2018/9/1322:48
 * AUTHOR:   Administrator
 */
package com.zhou.utils;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 2018/9/13  22:48
 * created by zhoumb
 */
public class JoinerTest {

    private final List<String> stringList = Arrays.asList(
            "google", "guava", "java", "scala", "kafka"
    );

    private final List<String> stringListWithNull = Arrays.asList(
            "google", "guava", "java", "scala", null
    );

    @Test
    public void testJoinOnJoin() {
        String join = Joiner.on("#").join(stringList);
        System.out.println(join);
    }
}
