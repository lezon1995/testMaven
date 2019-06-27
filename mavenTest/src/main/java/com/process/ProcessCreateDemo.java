package com.process;

/**
 * @author zhuliang
 * @date 2019/5/28 16:22
 */
public class ProcessCreateDemo {
    public static void main(String[] args) throws Exception {

        Runtime runtime = Runtime.getRuntime();

        Process exec = runtime.exec("cmd /k start https://www.baidu.com");
//        Process exec = runtime.exec("ipconfig");

        exec.exitValue();

    }
}
