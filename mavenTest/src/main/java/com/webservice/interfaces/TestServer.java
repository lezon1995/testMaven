package com.webservice.interfaces;

import javax.xml.ws.Endpoint;

public class TestServer {
    public static void main(String[] args) {

        FuncInterfaceImpl funcInterface = new FuncInterfaceImpl();

        Endpoint.publish("http://localhost:8888/func/1", funcInterface);

        System.out.println("webservice started...");

    }
}
