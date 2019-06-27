package com.proto.java;

import java.io.*;
import java.util.Arrays;

public class JAVA2Bytes {

	public static void main(String[] args) throws Exception {
		byte[] bytes = toBytes();
		toPlayer(bytes);
	}
	
	
	/**
	 * 序列化
	 * @throws IOException 
	 */
	public static byte[] toBytes() throws IOException{
		
		Student student = new Student(50.5f, 20, "张三");

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		
		//写入对象
		objectOutputStream.writeObject(student);
		
		//获取 字节数组
		byte[] byteArray = byteArrayOutputStream.toByteArray();
		System.out.println(Arrays.toString(byteArray));
		return byteArray;
	}
	
	
	/**
	 * 反序列化
	 * @param bs
	 * @throws Exception 
	 */
	public static void toPlayer(byte[] bs) throws Exception{
		
		ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(bs));
		Student student = (Student)inputStream.readObject();
		
		//打印
		 System.out.println("grade:" + student.getGrade());
		 System.out.println("age:" + student.getAge());
		 System.out.println("name:" + student.getName());
	}

}
