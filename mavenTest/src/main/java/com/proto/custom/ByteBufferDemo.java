package com.proto.custom;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class ByteBufferDemo {
    public static void main(String[] args) {
        int id=123456789;
        int age=101;

        ByteBuffer buffer = ByteBuffer.allocate(8);
//        buffer.putInt(id);
//        buffer.putInt(age);
        buffer.putLong(8l);
        byte[] array = buffer.array();
        System.out.println(Arrays.toString(array));


        ByteBuffer wrap = ByteBuffer.wrap(array);
        System.out.println("id="+ wrap.getInt()+"\nage="+ (int)wrap.getChar());
        System.out.println("\nage="+ (int)wrap.getChar());
    }
}
