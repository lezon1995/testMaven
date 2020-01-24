package com.regex;

import com.alibaba.fastjson.JSON;
import io.netty.handler.codec.http.HttpHeaderUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Wentworth .
 * @date 2019/12/17 4:22 下午
 */
public class RegexDemo {
    public static void main(String[] args) {
        String s = "Forgot to away arm {0} ?";
        String s1 = "Forgot to away arm {0}?name=zhangsan";
        String content = "05:10";
        String pattern = "\\d{2}:\\d{2}";

        String regex = "[\\?]";
        String[] split = s.split(regex);
        run(split);
        System.out.println("---");
        String[] split1 = s1.split(regex);
        run(split1);
    }
    public static void run(String[] array){
        for (String s : array) {
            System.out.println(s);
        }
    }
}


