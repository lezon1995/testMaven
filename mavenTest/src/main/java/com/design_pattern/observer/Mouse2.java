package com.design_pattern.observer;

public class Mouse2 implements Mouse {
    private String name;
    private Cat cat;

    public Mouse2(String name, Cat cat) {
        this.name = name;
        this.cat = cat;
        this.cat.getList().add(this);
    }

    @Override
    public void printStatus() {
        System.out.println("我是2号老鼠：" + name);
    }
}
