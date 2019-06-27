package com.design_pattern.base;

public class FileStream implements Stream {
    @Override
    public void read() {
        System.out.println("文件流");
    }

    @Override
    public void write() {

    }
}
