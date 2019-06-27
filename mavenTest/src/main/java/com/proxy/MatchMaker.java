package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MatchMaker implements InvocationHandler {

    private Person targer;

    public Person getProxyInstance(Person target) {
        this.targer = target;
        Class<?> clazz = targer.getClass();
        return (Person) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this::invoke);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("===============================");
//        targer.findLove();
        method.invoke(targer, args);
        System.out.println("===============================");
        return null;
    }

}
