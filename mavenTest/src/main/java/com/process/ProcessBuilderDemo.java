package com.process;

import com.taobao.arthas.common.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wentworth .
 * @date 2019/11/29 4:09 下午
 */
public class ProcessBuilderDemo {
    public static void main(String[] args) throws Exception {
        List<String> command = new ArrayList<>();
        command.add("ifconfig");
        ProcessBuilder pb = new ProcessBuilder(command);
        final Process proc = pb.start();
        Thread redirectStdout = new Thread(() -> {
            InputStream inputStream = proc.getInputStream();
            try {
                System.out.println("out");
                System.out.println(IOUtils.toString(inputStream));
            } catch (IOException e) {
                IOUtils.close(inputStream);
            }

        });

        Thread redirectStderr = new Thread(() -> {
            InputStream inputStream = proc.getErrorStream();
            try {
                System.out.println("error");
                System.err.println(IOUtils.toString(inputStream));
            } catch (IOException e) {
                IOUtils.close(inputStream);
            }

        });
        redirectStdout.start();
        redirectStderr.start();
        redirectStdout.join();
        redirectStderr.join();

        int exitValue = proc.exitValue();
        System.out.println(exitValue);
    }
}
