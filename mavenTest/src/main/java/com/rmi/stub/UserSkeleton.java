package com.rmi.stub;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ServerSocket 模拟RMI框架 server端
 *
 * @author zhuliang
 * @date 2019/5/9
 */
public class UserSkeleton extends Thread {

    private UserServer userServer;

    public UserSkeleton(UserServer userServer) {
        this.userServer = userServer;
    }


    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("服务端正在监听。。。");
            Socket socket = serverSocket.accept();
            System.out.println("收到客户端连接："+serverSocket.getInetAddress().getHostAddress());
            while (socket != null) {
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

                String method = (String) inputStream.readObject();

                if (method.equals("age")) {
                    int age = userServer.getAge();

                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

                    outputStream.writeInt(age);

                    outputStream.flush();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
