package com.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Wentworth .
 * @date 2019-10-26 11:29
 */
public class CameraInfoBean {
    private String cameraId;
    private String type;

    public static void main(String[] args) throws IOException {
//        StringBuffer stringBuffer = new StringBuffer();
//        Consumer<String> consumer = stringBuffer::append;
//        consumer.accept("asd");
//        System.out.println(stringBuffer.toString());

//        test(new Func1<String>() {
//            @Override
//            public void consume(String s) {
//                System.out.println(s);
//            }
//        }, "asd");
//        Arrays.asList("c", "d", "a", "b", "e").stream().sorted().forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });
//
//        System.out.println("---");

//        Stream<Object> objectStream = Arrays.asList("a", "b", "c", "d", "e").stream().flatMap(new Function<String, Stream<?>>() {
//            @Override
//            public Stream<?> apply(String s) {
//                return Stream.of(s, s + "_");
//            }
//        });
//        System.out.println("");
//        Stream<String> lines = Files.lines(Paths.get("/Users/wentworth/Documents/github/testMaven/mavenTest/src/main/java/com/stream/CameraInfoBean.java"));
//        lines.forEach(System.out::println);

        Stream<Integer> stream = Stream.iterate(0, new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 2;
            }
        });
        stream.limit(100).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });


        Stream.generate(new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        }).limit(100).sorted().collect(Collectors.partitioningBy(new Predicate<Double>() {
            @Override
            public boolean test(Double aDouble) {
                return aDouble > 0.5;
            }
        })).forEach(new BiConsumer<Boolean, List<Double>>() {
            @Override
            public void accept(Boolean aBoolean, List<Double> doubles) {
                System.out.println(aBoolean);
                System.out.println(doubles);
                System.out.println("------");
            }
        });

        try (
                 AutoCloseable object = new AutoCloseable() {
                    @Override
                    public void close() throws Exception {
                        System.out.println("close");
                        throw new RuntimeException("asd");
                    }
                };
        ) {
            throw new RuntimeException("zxc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void test(Func1<String> func1, String str) {
        func1.consume(str);
    }


    public String getCameraId() {
        return cameraId;
    }

    public void setCameraId(String cameraId) {
        this.cameraId = cameraId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
