package com.design_pattern.decorator.base;

import com.design_pattern.base.Stream;

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
