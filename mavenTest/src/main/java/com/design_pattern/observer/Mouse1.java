package com.design_pattern.observer;

public class Mouse1 implements Mouse {
    private String name;
    private Cat cat;

    public Mouse1(String name, Cat cat) {
        this.name = name;
        this.cat = cat;
        this.cat.getList().add(this);
    }

    @Override
    public void printStatus() {
        System.out.println("我是1号老鼠：" + name);

    }
}
