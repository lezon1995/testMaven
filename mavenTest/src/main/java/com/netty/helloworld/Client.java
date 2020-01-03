package com.netty.helloworld;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.ReferenceCountUtil;

import java.nio.charset.StandardCharsets;

public class Client {

	public static void main(String[] args) throws Exception {
		EventLoopGroup workgroup = new NioEventLoopGroup();
		Bootstrap b = new Bootstrap();
		b.group(workgroup)
		.channel(NioSocketChannel.class)
		.handler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel sc) throws Exception {
//				sc.pipeline().addLast(new ClientHandler());
				sc.pipeline().addLast(new ChannelHandlerAdapter(){
					@Override
					public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
						try {
							//do something msg
							ByteBuf buf = (ByteBuf)msg;
							byte[] data = new byte[buf.readableBytes()];
							buf.readBytes(data);
							String request = new String(data, StandardCharsets.UTF_8);
							System.out.println("Client: " + request);
						} finally {
							ReferenceCountUtil.release(msg);
						}
					}
				});
			}
		});
		ChannelFuture cf1 = b.connect("127.0.0.1", 8765).sync();
		cf1.channel().writeAndFlush(Unpooled.copiedBuffer("777".getBytes()));
		cf1.channel().closeFuture().sync();
		workgroup.shutdownGracefully();
		
	}
}
