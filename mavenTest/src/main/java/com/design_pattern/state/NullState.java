package com.design_pattern.state;

public class NullState implements DispenserState {

    @Override
    public void press() {
        System.out.println("There is not water poured!");
    }
}