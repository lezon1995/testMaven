package cn;

import com.github.houbb.opencc4j.util.ZhConverterUtil;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String original = "2019-03-25-1A";
//        String result = ZhConverterUtil.convertToSimple(original);
        System.out.println(original.substring(11,12));
    }
}
