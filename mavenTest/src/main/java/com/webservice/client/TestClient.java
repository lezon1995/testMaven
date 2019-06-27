package com.webservice.client;

import com.webservice.server.FuncInterfaceImpl;
import com.webservice.server.FuncInterfaceImplService;

public class TestClient {
    public static void main(String[] args) {

        FuncInterfaceImplService service = new FuncInterfaceImplService();

        FuncInterfaceImpl implPort = service.getFuncInterfaceImplPort();

        System.out.println(implPort.saySomething("哈哈哈哈哈哈哈哈"));

    }
}
