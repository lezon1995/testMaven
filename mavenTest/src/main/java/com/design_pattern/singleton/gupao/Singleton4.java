package com.design_pattern.singleton.gupao;

public class Singleton4 {

    public static int a=1;

    private Singleton4() {
        System.out.println("构造");
    }

    private static class LazyHolder {
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    public static final Singleton4 getInstance() {
        return LazyHolder.INSTANCE;
    }
}
