package com.rmi.stub;

public class UserServer extends  User{

    public static void main(String[] args) {
        UserServer server = new UserServer();
        server.setAge(18);

        UserSkeleton userSkeleton = new UserSkeleton(server);

        userSkeleton.start();
    }
}
