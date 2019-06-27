package com.proxy.custom_cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGMatchMaker implements MethodInterceptor {

    static int a = 0;

    public Object getProxyInstance(Class clazz) {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(clazz);

        enhancer.setCallback(this);

        return enhancer.create();
    }


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("===============================" + a++);
        Object aSuper = methodProxy.invokeSuper(obj, args);
//        method.invoke(obj,args);
        System.out.println("===============================" + a++);
        return aSuper;
    }
}
