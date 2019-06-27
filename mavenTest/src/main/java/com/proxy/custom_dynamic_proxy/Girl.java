package com.proxy.custom_dynamic_proxy;

public class Girl implements Person {
    private String sex;
    private String name;

    public Girl(String sex, String name) {
        this.sex = sex;
        this.name = name;
    }

    @Override
    public void findLove() {
        System.out.println(getName() + " is finding love");
        System.out.println(getName() + " is finding love");
        System.out.println(getName() + " is finding love");
    }

    @Override
    public String getSex() {
        return sex;
    }

    @Override
    public String getName() {
        return name;
    }
}
