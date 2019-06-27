package com.netty.helloworld;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NettyServer {
    public static void main(String[] args) throws Exception {
        EventLoopGroup boos = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                .group(boos, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel sc)throws Exception {
                        sc.pipeline().addLast(new StringDecoder());
                        sc.pipeline().addLast(new StringEncoder());
                        sc.pipeline().addLast(new ChannelHandlerAdapter(){

                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//                                ByteBuf buf = (ByteBuf)msg;
//                                byte[] data = new byte[buf.readableBytes()];
//                                buf.readBytes(data);
//                                String request = new String(data, "utf-8");
                                System.out.println("Server: " + msg);
                                //写给客户端
                                String response = "我是反馈的信息";
                                ctx.writeAndFlush("h=aaa"/*Unpooled.copiedBuffer("888".getBytes())*/);
//                                .addListener(ChannelFutureListener.CLOSE);
                            }
                        });
//                        ch.pipeline().addLast(new ServerHandler());
                    }
                });
        ChannelFuture f = serverBootstrap.bind(8765).sync();
        System.out.println("server started...");
        f.channel().closeFuture().sync();
        boos.shutdownGracefully();
        worker.shutdownGracefully();
    }
}