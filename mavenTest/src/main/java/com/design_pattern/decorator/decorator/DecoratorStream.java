package com.design_pattern.decorator.decorator;

import com.design_pattern.decorator.base.Stream;

public class DecoratorStream implements Stream {

    protected Stream stream;

    public DecoratorStream(Stream stream) {
        this.stream = stream;
    }

    @Override
    public void read() {

    }

    @Override
    public void write() {

    }
}
