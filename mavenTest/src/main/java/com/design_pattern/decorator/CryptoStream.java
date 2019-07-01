package com.design_pattern.decorator;

import com.design_pattern.decorator.base.Stream;
import com.design_pattern.decorator.decorator.DecoratorStream;

public class CryptoStream extends DecoratorStream {

    public CryptoStream(Stream stream) {
        super(stream);
    }

    @Override
    public void read() {
        System.out.println("===加密===");
        stream.read();
        System.out.println("===加密===");
    }

    @Override
    public void write() {
        stream.write();
    }
}
