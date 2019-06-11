package cn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class NIOFileCopy {

    public static void main(String[] args) throws Exception {
        copyFile(new File("E:\\学习资料\\架构师\\dubbo.mp4"), new File("E:\\学习资料\\架构师\\dubbo1.mp4"));
    }

    public static void copyFile(File source, File dest) throws Exception {
        FileChannel sourceChannel = new FileInputStream(source).getChannel();
        FileChannel destChannel = new FileOutputStream(dest).getChannel();
        for (long count = sourceChannel.size(); count > 0; ) {
            /* 返回已传输的字节数 */
            long transferred = sourceChannel.transferTo(sourceChannel.position(), count, destChannel);
            sourceChannel.position(sourceChannel.position() + transferred);
            count -= transferred;
        }
    }

}
