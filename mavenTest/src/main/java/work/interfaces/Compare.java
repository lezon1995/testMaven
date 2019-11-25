package work.interfaces;

import com.google.common.collect.Sets;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.function.Consumer;

/**
 * @author Wentworth .
 * @date 2019-09-09 16:53
 */
public class Compare {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(new File("/Users/wentworth/Documents/github/testMaven/mavenTest/src/main/java/work/interfaces/美国预发.log")));
        HashSet<String> americaSet = new HashSet<>();
        String line;
        while ((line = reader.readLine()) != null) {
            americaSet.add(line);
        }

        reader = new BufferedReader(new FileReader(new File("/Users/wentworth/Documents/github/testMaven/mavenTest/src/main/java/work/interfaces/中国预发.log")));
        HashSet<String> chinaSet = new HashSet<>();
        while ((line = reader.readLine()) != null) {
            chinaSet.add(line);
        }
        Sets.SetView<String> difference = Sets.difference(americaSet, chinaSet);
//        Sets.SetView<String> difference = Sets.difference(chinaSet, americaSet);
        difference.forEach(System.out::println);
        System.out.println(difference.size());
    }
}
