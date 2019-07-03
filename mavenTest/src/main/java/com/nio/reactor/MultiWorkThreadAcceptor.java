package com.nio.reactor;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多work 连接事件Acceptor,处理连接事件
 */
public class MultiWorkThreadAcceptor implements Runnable {
    private final Selector selector;
    private final ServerSocketChannel serverSocket;

    public MultiWorkThreadAcceptor(Selector selector, ServerSocketChannel serverSocket) {
        this.selector = selector;
        this.serverSocket = serverSocket;
        this.init();
    }

    // cpu线程数相同多work线程
    int workCount = Runtime.getRuntime().availableProcessors();
    SubReactor[] workThreadHandlers = new SubReactor[workCount];
    volatile int nextHandler = 0;


    public void init() {
        nextHandler = 0;
        for (int i = 0; i < workThreadHandlers.length; i++) {
            try {
                workThreadHandlers[i] = new SubReactor();
            } catch (Exception e) {
            }

        }
    }

    @Override
    public void run() {
        try {
            SocketChannel c = serverSocket.accept();
            if (c != null) {// 注册读写
                synchronized (c) {
                    // 顺序获取SubReactor，然后注册channel
                    SubReactor work = workThreadHandlers[nextHandler];
                    work.registerChannel(c);
                    nextHandler++;
                    if (nextHandler >= workThreadHandlers.length) {
                        nextHandler = 0;
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}

/**
 * 多work线程处理读写业务逻辑
 */
class SubReactor implements Runnable {
    final Selector selector;

    //多线程处理业务逻辑
    int workCount = Runtime.getRuntime().availableProcessors();
    ExecutorService executorService = Executors.newFixedThreadPool(workCount);


    public SubReactor() throws Exception {
        // 每个SubReactor 一个selector
        this.selector = SelectorProvider.provider().openSelector();
    }

    /**
     * 注册chanel
     *
     * @param sc
     * @throws Exception
     */
    public void registerChannel(SocketChannel sc) throws Exception {
        sc.register(selector, SelectionKey.OP_READ | SelectionKey.OP_CONNECT);
    }

    @Override
    public void run() {
        while (true) {
            try {
                //每个SubReactor 自己做事件分派处理读写事件
                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isReadable()) {
                        read();
                    } else if (key.isWritable()) {
                        write();
                    }
                    iterator.remove();
                }

            } catch (Exception e) {

            }
        }
    }

    private void read() {
        //任务异步处理
        executorService.submit(() -> process());
    }

    private void write() {
        //任务异步处理
        executorService.submit(() -> process());
    }

    /**
     * task 业务处理
     */
    public void process() {
        //do IO ,task,queue something
    }
}