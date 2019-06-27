package com.proxy;

public class ProxyTest {
    public static void main(String[] args) throws Exception {

        Person proxyInstance = new MatchMaker().getProxyInstance(new Girl("female", "mary"));
        Class<? extends Person> aClass = proxyInstance.getClass();
        System.out.println(aClass);
        proxyInstance.findLove();

    }


}
