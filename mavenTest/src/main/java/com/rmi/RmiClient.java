package com.rmi;

import java.rmi.Naming;

public class RmiClient {
    public static void main(String[] args) throws Exception {

        RmiInterface lookup = (RmiInterface) Naming.lookup("rmi://localhost:8888/getString");

        String string = lookup.getString("hhhhhhhhhhhh");

        System.out.println(string);

    }
}
