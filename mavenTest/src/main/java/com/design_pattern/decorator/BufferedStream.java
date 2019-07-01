package com.design_pattern.decorator;

import com.design_pattern.decorator.base.Stream;
import com.design_pattern.decorator.decorator.DecoratorStream;

public class BufferedStream extends DecoratorStream {

    public BufferedStream(Stream stream) {
        super(stream);
    }

    @Override
    public void read() {
        System.out.println("===缓冲===");
        stream.read();
        System.out.println("===缓冲===");
    }

    @Override
    public void write() {
        stream.write();
    }
}
