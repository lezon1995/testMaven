package com.proto.custom;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import java.util.Arrays;

public class ChannelBufferDemo {
    public static void main(String[] args) {
        ChannelBuffer buffer = ChannelBuffers.dynamicBuffer();
        buffer.writeInt(101);
        buffer.writeDouble(101.11d);
        byte[] bytes = new byte[buffer.writerIndex()];
        buffer.readBytes(bytes);
        ChannelBuffer buffer1 = ChannelBuffers.wrappedBuffer(bytes);
        int i = buffer1.readInt();
        double d = buffer1.readDouble();
        System.out.println(i+"-"+d);
        System.out.println(Arrays.toString(bytes));



    }
}
