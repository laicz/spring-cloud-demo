/**
 * Date:     2018/8/1420:42
 * AUTHOR:   Administrator
 */
package com.zhou.springdata;

import ch.qos.logback.classic.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 2018/8/14  20:42
 * created by zhoumb
 */

public class LogbackTest {
    private static final Logger logger = LoggerFactory.getLogger(LogbackTest.class);

    public static void main(String[] args) {
        //这里强制类型转换时为了能设置 logger 的 Level : TRACE < DEBUG < INFO <  WARN < ERROR
        ch.qos.logback.classic.Logger logback_logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.zhou");
        logback_logger.setLevel(Level.DEBUG);

        logback_logger.error("logback_logger.error");
        logback_logger.warn("logback_logger.warn");
        logback_logger.info("logback_logger.info");
        logback_logger.debug("logback_logger.debug");
        logback_logger.trace("logback_logger.trace");

        logger.error("logger.error");
        logger.warn("logger.warn");
        logger.info("logger.info");
        logger.debug("logger.debug");
        logger.trace("logger.trace");

    }
}
