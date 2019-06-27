package com.difference;

public class Test {
    public static void main(String[] args) throws Exception {
        String a = "a";
        String b = new String("a");
        System.out.println(a==b);

//        WeakHashMap<String, String> weakmap = new WeakHashMap<>();
//        HashMap<String, String> map = new HashMap<>();
//        map.put(a, "aaa");
//        map.put(b, "bbb");
//
//
//        weakmap.put(a, "aaa");
//        weakmap.put(b, "bbb");
//
//        map.remove(a);
//
//        a = null;
//        b = null;
//
//        System.gc();
//        Thread.sleep(1000);
//        for (Object o : map.entrySet()) {
//            Map.Entry en = (Map.Entry) o;
//            System.out.println("map:" + en.getKey() + ":" + en.getValue());
//        }
//
//        for (Object o : weakmap.entrySet()) {
//            Map.Entry en = (Map.Entry) o;
//            System.out.println("weakmap:" + en.getKey() + ":" + en.getValue());
//
//        }
    }


}  