package com.proxy.custom_dynamic_proxy;



public class MyProxyTest {
    public static void main(String[] args) throws Exception {

        Person proxyInstance = new MatchMaker().getProxyInstance(new Girl("female", "lily"));
        try {
            proxyInstance.findLove();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }


}
