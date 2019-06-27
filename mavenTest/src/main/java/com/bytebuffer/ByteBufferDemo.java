package com.bytebuffer;

import java.nio.IntBuffer;

/**
 * @author zhuliang
 * @date 2019/6/22 14:38
 */
public class ByteBufferDemo {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(8);
        for (int i = 0; i < buffer.capacity(); i++) {
            //每次调用put或者get方法都会让position+1
            buffer.put(i);
        }
        //让ByteBuffer的position重置为0 这样就可以让buffer.hasRemaining()为true
        buffer.flip();
        buffer.limit(4);
        for (int i = 0; i < buffer.limit(); i++) {
            buffer.put(2*i);
        }

//        buffer.flip();
        buffer.clear();
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get()+" ");
        }
    }
}
