package com.asm;

import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * 自定义类加载器
 *
 * @author zhuliang
 * @date 2019/7/3 11:50
 */
public class MyClassLoader extends ClassLoader implements Opcodes {


    public MyClassLoader() {
        super();
    }

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    public Class<?> defineClass(String name, byte[] b) {
        return super.defineClass(name, b, 0, b.length);
    }

}