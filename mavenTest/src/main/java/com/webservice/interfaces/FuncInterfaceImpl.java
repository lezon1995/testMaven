package com.webservice.interfaces;

import javax.jws.WebService;

@WebService
public class FuncInterfaceImpl implements FuncInterface {

    @Override
    public String saySomething(String text) {
        System.out.println("saySomething is called");
        return "Hi ->" + text;
    }

}

