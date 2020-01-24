package com.io.nio;

import java.io.*;
import java.nio.channels.FileChannel;

public class NIOFileCopy {

    public static void main(String[] args) throws Exception {
        String filename="烟袋斜街.mp3";
        copyFile(new File("E:\\Music\\"+filename), new File("H:\\MIX 4\\"+filename));
    }

    public static void copyFile(File source, File dest) throws Exception {
        FileChannel sourceChannel = new FileInputStream(source).getChannel();
        FileChannel destChannel = new FileOutputStream(dest).getChannel();
        long start = System.currentTimeMillis();
        for (long count = sourceChannel.size(); count > 0; ) {
            /* 返回已传输的字节数 */
            long transferred = sourceChannel.transferTo(sourceChannel.position(), count, destChannel);
            sourceChannel.position(sourceChannel.position() + transferred);
            count -= transferred;
        }
        long end = System.currentTimeMillis();
        System.out.println("complete in " + (end - start) + " ms");
    }

    public static void copyFile1(File source, File dest) throws Exception {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
        byte[] bytes = new byte[1024 * 10];
        int len = 0;
        long start = System.currentTimeMillis();
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        long end = System.currentTimeMillis();
        System.out.println("complete in " + (end - start) + " ms");
        bis.close();
        bos.close();
    }

}
