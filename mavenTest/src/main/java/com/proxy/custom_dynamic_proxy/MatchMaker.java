package com.proxy.custom_dynamic_proxy;

import java.lang.reflect.Method;

public class MatchMaker implements MyInvocationHandler {

    private Person targer;

    public MatchMaker() {
        System.out.println("构造方法");
    }

    public Person getProxyInstance(Person target) {
        this.targer = target;
        Class<?> clazz = targer.getClass();
        return (Person) MyProxy.newProxyInstance(new MyClassLoader(), clazz.getInterfaces()[0], this);
    }

    @Override
    public Object invoke(Object object, Method method, Object[] args) throws Throwable {
        System.out.println("===============================");
        method.invoke(targer, args);
        System.out.println("===============================");
        return null;
    }


}
