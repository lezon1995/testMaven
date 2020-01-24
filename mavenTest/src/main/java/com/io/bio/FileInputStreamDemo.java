package com.io.bio;

import java.io.*;
import java.lang.reflect.Method;

/**
 * FileInputStream 在使用完以后，不关闭流，想二次使用可以怎么操作
 *
 * @author zhuliang
 * @date 2019/7/27 23:10
 */
public class FileInputStreamDemo {
    public static void main(String[] args) throws Exception {
        String file = "G:\\java.md";
        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream("G:\\java1.md");
        FileOutputStream outputStreams = new FileOutputStream("G:\\java2.md");
        int len;
        byte[] by = new byte[8192];
        while ((len = inputStream.read(by)) != -1) {
            outputStream.write(by, 0, len);
        }
        //方法一：FileInputStream的构造方法实际上是调用了open-open0私有方法，通过反射再次调用，就可以实现不关流二次使用
        if (inputStream.read() == -1) {
            Class in = inputStream.getClass();
            Method openo = in.getDeclaredMethod("open0", String.class);
            openo.setAccessible(true);
            openo.invoke(inputStream, file);
        }

        while ((len = inputStream.read(by)) != -1) {
            outputStreams.write(by, 0, len);
        }
        outputStream.close();
    }


}
