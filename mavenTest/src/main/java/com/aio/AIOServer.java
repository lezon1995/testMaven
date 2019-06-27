package com.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author zhuliang
 * @date 2019/6/22 16:23
 */
public class AIOServer {

    private int port;

    public AIOServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws IOException {
        AIOServer aioServer = new AIOServer(8888);
        aioServer.listen();
        System.in.read();
    }

    private void listen() {
        try {
            AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open();

            server.bind(new InetSocketAddress(port));

            server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
                @Override
                public void completed(AsynchronousSocketChannel client, Object attachment) {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    client.read(buffer);

                    System.out.println(new String(buffer.array()));
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    System.out.println(exc.getMessage());
                }
            });
            System.out.println("server started ...");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
