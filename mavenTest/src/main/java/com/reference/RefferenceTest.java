package com.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author zhuliang
 * @date 2019/6/8 23:01
 */
public class RefferenceTest {
    public static void main(String[] args) {
        /*
        String s1 = new String("abc");
        String s2 = "abc";
        s1==s2 = false
        */


        /*
        String s1 = new String("abc");
        String s2 = s1.intern();
        s1="abc";
         s1==s2 = true
        */

        String s1="abc";
        String s2 = new String("abc");
        String s3 = s2.intern();


        System.out.println(s1==s3);
    }


    /**
     * 结果
     * java.lang.Object@7ea987ac
     * null
     * abc  {@link String} 这里之所以没有被GC回收 是因为WeakReference 引用的是常量池中"abc"的地址
     * null
     */
    public static void test1(){
        SoftReference<Object> soft = new SoftReference<>(new Object());
        WeakReference<Object> weak = new WeakReference<>(new Object(){
            @Override
            protected void finalize() throws Throwable {
                System.out.println(this + "已经被调用finalize");
            }
        });
        WeakReference<String> weakString = new WeakReference<>("abc");
        PhantomReference<Object> phantom = new PhantomReference<>(new Object(), new ReferenceQueue<>());
        System.gc();
        System.out.println(soft.get());
        System.out.println(weak.get());
        System.out.println(weakString.get());
        System.out.println(phantom.get());
    }


    /**
     * 结果
     * java.lang.Object@7ea987ac
     * null
     * null {@link String} 这里之所以被GC回收 是因为WeakReference 引用的是堆内存中new String对象的地址
     * null
     */
    public static void test2(){
        SoftReference<Object> soft = new SoftReference<>(new Object());
        WeakReference<Object> weak = new WeakReference<>(new Object(){
            @Override
            protected void finalize() throws Throwable {
                System.out.println(this + "已经被调用finalize");
            }
        });
        WeakReference<String> weakString = new WeakReference<>(new String("abc"));
        PhantomReference<Object> phantom = new PhantomReference<>(new Object(), new ReferenceQueue<>());
        System.gc();
        System.out.println(soft.get());
        System.out.println(weak.get());
        System.out.println(weakString.get());
        System.out.println(phantom.get());
    }


}
