package com.design_pattern.decorator.base;

public class NetStream implements Stream {
    @Override
    public void read() {
        System.out.println("网络流");
    }

    @Override
    public void write() {

    }
}
