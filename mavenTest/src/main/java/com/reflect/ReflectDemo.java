package com.reflect;

import java.lang.reflect.Constructor;

/**
 * @author zhuliang
 * @date 2019/6/27 22:50
 */
public class ReflectDemo {

    public static void main(String[] args) throws Exception {
        Class studentClazz = Class.forName("com.reflect.Student");
        Constructor constructor = studentClazz.getDeclaredConstructor(String.class, Integer.class);
        Object xiaoming = constructor.newInstance("xiaoming", 18);
        Student student = xiaoming instanceof Student ? ((Student) xiaoming) : null;
        System.out.println(student);
    }
}
