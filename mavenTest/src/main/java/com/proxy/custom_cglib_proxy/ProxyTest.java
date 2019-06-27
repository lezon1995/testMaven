package com.proxy.custom_cglib_proxy;

public class ProxyTest {
    public static void main(String[] args) throws Exception {

        CGGirl instance = (CGGirl) new CGMatchMaker().getProxyInstance(CGGirl.class);
        Class aClass = instance.getClass();
        System.out.println(aClass);
        instance.findLove();

    }


}
