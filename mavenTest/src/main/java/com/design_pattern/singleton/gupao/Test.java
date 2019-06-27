package com.design_pattern.singleton.gupao;

public class Test {
    public static void main(String[] args) {
        System.out.println(Singleton4.a);

        Singleton4 instance = Singleton4.getInstance();
        Singleton4 instance1 = Singleton4.getInstance();
        Singleton4 instance2 = Singleton4.getInstance();

        System.out.println(instance);
        System.out.println(instance1);
        System.out.println(instance2);
    }
}
