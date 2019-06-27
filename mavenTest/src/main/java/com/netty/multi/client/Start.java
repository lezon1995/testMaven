package com.netty.multi.client;

/**
 * 启动类
 * @author -琴兽-
 *
 */
public class Start {

	public static void main(String[] args) {
//		NullPointerException exception = new NullPointerException();
		Exception exception = new RuntimeException();
		System.out.println(exception.getMessage());

//		MultClient client = new MultClient();
//		client.init(5);
//
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		while(true){
//			try {
//				System.out.println("请输入:");
//				String msg = bufferedReader.readLine();
//				client.nextChannel().writeAndFlush(client.nextChannel()+":"+msg);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	}

}
