package com.rmi.stub;

public class UserClient {
    public static void main(String[] args) throws Exception {
        UserStub stub = new UserStub();

        int age = stub.getAge();

        System.out.println("age : " + age);
    }
}
