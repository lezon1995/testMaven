package com.design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Cat {

    private List<Mouse> list=new ArrayList<Mouse>();

    public void catchMouse() {
        System.out.println("下面是我抓到的老鼠：");
        for (Mouse m : list) {
            m.printStatus();
        }
    }

    public List<Mouse> getList() {
        return list;
    }

    public void setList(List<Mouse> list) {
        this.list = list;
    }
}
