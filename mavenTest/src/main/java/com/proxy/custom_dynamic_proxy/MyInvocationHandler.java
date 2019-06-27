package com.proxy.custom_dynamic_proxy;

import java.lang.reflect.Method;

public interface MyInvocationHandler {
    Object invoke(Object object, Method method, Object[] args) throws Throwable;
}
