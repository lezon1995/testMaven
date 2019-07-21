package com.thread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhuliang
 * @date 2019/7/19 17:01
 */
public class InterruptDemo {
    static int i = 0;

    public static void main(String[] args) throws InterruptedException, IOException {
        Thread thread = new Thread(() -> {
            try {
                for (int j = 0; j < 100; j++) {
                    i++;
                    Thread.sleep(100);
                    if (j==20){
                        throw new RuntimeException("asd");
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("interrupted by"+e);
            }
        });

        List l= Arrays.asList(1,2,3);

        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
        System.out.println(i);
        Thread.sleep(3000);
        System.out.println(i);
        System.in.read();
    }
}
