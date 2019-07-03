package com.nio.reactor;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 等待事件到来，分发事件处理
 */
public class Reactor implements Runnable {

    private final ServerSocketChannel serverSocket;

    private Selector selector;

    public Reactor(Selector selector, ServerSocketChannel serverSocket) throws Exception {
        this.selector = selector;
        this.serverSocket = serverSocket;
        SelectionKey key = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        // attach Acceptor 处理新连接
        key.attach(new Acceptor(selector, serverSocket));
    }

    @Override
    public void run() {
        try {
            System.out.println("server started and waiting for connection . . .");
            while (!Thread.interrupted()) {
                selector.select();
                Set selected = selector.selectedKeys();
                Iterator it = selected.iterator();
                while (it.hasNext()) {
                    //分发事件处理
                    dispatch((SelectionKey) (it.next()));
                    it.remove();
                }
            }
        } catch (IOException ex) {
            //do something
        }
    }

    void dispatch(SelectionKey key) {
        // 若是连接事件获取是acceptor
        // 若是IO读写事件获取是handler
        Runnable runnable = (Runnable) (key.attachment());
        if (runnable != null) {
            runnable.run();
        }
    }

}

/**
 * 连接事件就绪,处理连接事件
 */
class Acceptor implements Runnable {
    private final Selector selector;
    private final ServerSocketChannel serverSocket;

    public Acceptor(Selector selector, ServerSocketChannel serverSocket) {
        this.selector = selector;
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        try {
            SocketChannel c = serverSocket.accept();
            if (c != null) {// 注册读写
                new Handler(c, selector);
            }
        } catch (Exception e) {

        }
    }
}

/**
 * 处理读写业务逻辑
 */
class Handler implements Runnable {
    public static final int READING = 0, WRITING = 1;
    int state;
    final SocketChannel socket;
    final SelectionKey selectionKey;

    public Handler(SocketChannel socket, Selector selector) throws Exception {
        this.state = READING;
        this.socket = socket;
        socket.configureBlocking(false);
        selectionKey = socket.register(selector, SelectionKey.OP_READ);
        selectionKey.attach(this);
    }

    @Override
    public void run() {
        if (state == READING) {
            read();
        } else if (state == WRITING) {
            write();
        }
    }

    private void read() {
        processRead();
        //下一步处理写事件
        selectionKey.interestOps(SelectionKey.OP_WRITE);
        this.state = WRITING;
    }

    private void write() {
        processWrite();
        //下一步处理读事件
        selectionKey.interestOps(SelectionKey.OP_READ);
        this.state = READING;
    }

    private void processWrite() {
        try {
            socket.write(ByteBuffer.wrap("message from server".getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * task 业务处理
     */
    public void processRead() {
        //do something
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            int len = socket.read(buffer);
            System.out.println(new String(buffer.array(), 0, len));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}