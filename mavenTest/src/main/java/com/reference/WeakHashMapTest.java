package com.reference;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest {
    public static void main(String[] args) throws Exception {
        String a = new String("a");
        String b = new String("b");

        WeakHashMap<String, String> weakmap = new WeakHashMap<>();
        HashMap<String, String> map = new HashMap<>();
//        map.put(a, "aaa");
//        map.put(b, "bbb");


        weakmap.put(a, "aaa");
        weakmap.put(b, "bbb");

//        map.remove(a);
//        map.remove(b);

        a = null;
//        b = null;

        System.gc();
        Thread.sleep(1000);
//        for (Object o : map.entrySet()) {
//            Map.Entry en = (Map.Entry) o;
//            System.out.println("map:" + en.getKey() + ":" + en.getValue());
//        }

        for (Object o : weakmap.entrySet()) {
            Map.Entry en = (Map.Entry) o;
            System.out.println("weakmap:" + en.getKey() + ":" + en.getValue());

        }

//        Iterator iter = weakmap.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry en = (Map.Entry) iter.next();
//            System.out.printf("next : %s - %s\n", en.getKey(), en.getValue());
//        }
    }


}  