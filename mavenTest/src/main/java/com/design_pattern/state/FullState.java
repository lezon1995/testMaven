package com.design_pattern.state;

public class FullState implements DispenserState {

    @Override
    public void press() {
        System.out.println("Water is pouring!");
    }
}
