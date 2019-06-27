package com.netty.helloworld;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.ReferenceCountUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel sc) throws Exception{
                        sc.pipeline().addLast(new StringDecoder());
                        sc.pipeline().addLast(new StringEncoder());
                        sc.pipeline().addLast(new ChannelHandlerAdapter(){
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                try {
                                    //do something msg
//                                    ByteBuf buf = (ByteBuf)msg;
//                                    byte[] data = new byte[buf.readableBytes()];
//                                    buf.readBytes(data);
//                                    String request = new String(data, StandardCharsets.UTF_8);
                                    System.out.println("Client: " + msg);
                                } finally {
                                    ReferenceCountUtil.release(msg);
                                }
                            }
                        });
//                        ch.pipeline().addLast(new ClientHandler());
                    }
                });

        ChannelFuture cf1 = bootstrap.connect("127.0.0.1", 8765).sync();
        cf1.channel().writeAndFlush(format.format(new Date()) + "你好 我是客户端");
//        cf1.channel().writeAndFlush(Unpooled.copiedBuffer("777".getBytes()));
        cf1.channel().closeFuture().sync();
        group.shutdownGracefully();

//        while (true) {
//            channel.writeAndFlush(format.format(new Date()) + ": hello world!" + "_B");
//            Thread.sleep(2000);
//        }
    }
}