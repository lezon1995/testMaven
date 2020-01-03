package com.netty.helloworld;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.nio.charset.StandardCharsets;

public class Server {

	public static void main(String[] args) throws Exception {
		//1 第一个线程组 是用于接收Client端连接的
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		//2 第二个线程组 是用于实际的业务处理操作的
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		//3 创建一个辅助类Bootstrap，就是对我们的Server进行一系列的配置
		ServerBootstrap b = new ServerBootstrap(); 
		//把俩个工作线程组加入进来
		b.group(bossGroup, workerGroup)
		//我要指定使用NioServerSocketChannel这种类型的通道
		 .channel(NioServerSocketChannel.class)
		//一定要使用 childHandler 去绑定具体的 事件处理器
		 .childHandler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel sc) throws Exception {
//				sc.pipeline().addLast(new ServerHandler());
				sc.pipeline().addLast(new ChannelHandlerAdapter(){
					@Override
					public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
						//do something msg
						ByteBuf buf = (ByteBuf)msg;
						byte[] data = new byte[buf.readableBytes()];
						buf.readBytes(data);
						String request = new String(data, StandardCharsets.UTF_8);
						System.out.println("Server: " + request);
						//写给客户端
						String response = "我是反馈的信息";
						ctx.writeAndFlush(Unpooled.copiedBuffer(("server : "+request).getBytes()));
						//.addListener(ChannelFutureListener.CLOSE);
					}
				});
			}
		});
		//绑定指定的端口 进行监听
		ChannelFuture f = b.bind(8765).sync();
		System.out.println("start successful , listening on port 8765 . . .");
		f.channel().closeFuture().sync();
		bossGroup.shutdownGracefully();
		workerGroup.shutdownGracefully();
	}
}
