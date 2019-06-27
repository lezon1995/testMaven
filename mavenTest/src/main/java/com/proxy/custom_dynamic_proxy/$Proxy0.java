package com.proxy.custom_dynamic_proxy;

import java.lang.reflect.Method;

public class $Proxy0 implements Person {
    MyInvocationHandler h;

    public $Proxy0(MyInvocationHandler h) {
        this.h = h;
    }

    ;

    public String getName() {
        try {
            Method m = Person.class.getMethod("getName", new Class[]{});
            this.h.invoke(this, m, null);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    ;

    public void findLove() {
        try {
            Method m = Person.class.getMethod("findLove", new Class[]{});
            this.h.invoke(this, m, null);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    ;

    public String getSex() {
        try {
            Method m = Person.class.getMethod("getSex", new Class[]{});
            this.h.invoke(this, m, null);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    ;
}