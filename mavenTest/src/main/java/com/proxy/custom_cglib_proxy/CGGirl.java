package com.proxy.custom_cglib_proxy;


public class CGGirl {
    private String sex;
    private String name;

    public CGGirl() {
    }

    public CGGirl(String sex, String name) {
        this.sex = sex;
        this.name = name;
    }

    public void findLove() {
        System.out.println(" is finding love");
    }

    public String getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }
}
