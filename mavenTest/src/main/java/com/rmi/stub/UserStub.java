package com.rmi.stub;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class UserStub extends User {

    private Socket socket;

    public UserStub() throws IOException {
        this.socket = new Socket("localhost", 8888);
    }


    @Override
    public int getAge() throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

        outputStream.writeObject("age");

        outputStream.flush();

        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        return inputStream.readInt();
    }

}
