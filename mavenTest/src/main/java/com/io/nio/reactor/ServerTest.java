package com.io.nio.reactor;

import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @author zhuliang
 * @date 2019/7/4 0:03
 */
public class ServerTest {
    public static void main(String[] args) throws Exception {
        // 获得一个ServerSocket通道
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        // 设置通道为非阻塞
        serverChannel.configureBlocking(false);
        // 将该通道对应的ServerSocket绑定到port端口
        serverChannel.socket().bind(new InetSocketAddress(8888));
        // 获得一个通道管理器
        Selector selector = Selector.open();
        // 将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件,注册该事件后，
        // 当该事件到达时，selector.select()会返回，如果该事件没到达selector.select()会一直阻塞。
//        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        Reactor reactor = new Reactor(selector, serverChannel);
        new Thread(reactor).start();
        System.in.read();
    }
}
