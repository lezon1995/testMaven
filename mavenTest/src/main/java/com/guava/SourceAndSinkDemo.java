package com.guava;

import com.google.common.base.Charsets;
import com.google.common.io.CharSource;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

/**
 * @author Wentworth .
 * @date 2019/12/6 3:38 下午
 */
public class SourceAndSinkDemo {
    public static void main(String[] args) throws IOException {
        Files.createParentDirs(new File("/Users/wentworth/Documents/github/testMaven/mavenTest/src/main/java/com/guava/a/b/c/GuavaDemo.java"));
    }
}
