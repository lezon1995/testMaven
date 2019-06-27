package com.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RmiServer {
    public static void main(String[] args) throws Exception {

        RmiInterface anInterface = new RmiInterfaceImpl();

        LocateRegistry.createRegistry(8888);

        Naming.bind("rmi://localhost:8888/getString", anInterface);

        System.out.println("server start up");

    }
}
