package com.design_pattern.facade;

public class Facade {
    Module1 module1 = new Module1();
    Module2 module2 = new Module2();
    Module3 module3 = new Module3();

    public void do1() {
        module1.doA();
        module1.doB();
    }

    public void do2() {
        module2.doB();
        module2.doA();
    }

    public void do3() {
        module3.doC();
        module3.doB();
    }
}
