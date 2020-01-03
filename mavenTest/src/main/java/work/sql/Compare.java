package work.sql;

import com.google.common.collect.Sets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;

/**
 * @author Wentworth .
 * @date 2020/1/3 11:42 上午
 */
public class Compare {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(new File("/Users/wentworth/Documents/github/testMaven/mavenTest/src/main/java/work/sql/table/us.log")));
        HashSet<String> americaSet = new HashSet<>();
        String line;
        while ((line = reader.readLine()) != null) {
            americaSet.add(line);
        }

        reader = new BufferedReader(new FileReader(new File("/Users/wentworth/Documents/github/testMaven/mavenTest/src/main/java/work/sql/table/we.log")));
        HashSet<String> westSet = new HashSet<>();
        while ((line = reader.readLine()) != null) {
            westSet.add(line);
        }
//        Sets.SetView<String> difference = Sets.difference(americaSet, westSet);
        Sets.SetView<String> difference = Sets.intersection(westSet, americaSet);
        difference.forEach(System.out::println);
        System.out.println(difference.size());
    }
}
