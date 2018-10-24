/**
 * Date:     2018/10/2420:47
 * AUTHOR:   Administrator
 */
package com.zhou.mode_003_decorator.myInputStream;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 使用装饰者模式写自己的输入的流
 * 大写输入流
 *
 * 2018/10/24  20:47
 * created by zhoumb
 */
public class UpperCaseInputStream extends FilterInputStream {

    protected UpperCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read(byte[] b) throws IOException {
        int read = super.read(b);
        if (read == -1) {
            return read;
        }
        return Character.toUpperCase(read);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b, off, len);
        for (int i = 0; i < result; i++) {
            b[i] = (byte) Character.toUpperCase((char) b[i]);
        }
        return result;
    }

}
