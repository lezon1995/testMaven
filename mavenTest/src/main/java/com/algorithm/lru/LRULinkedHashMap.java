package com.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    //定义缓存的容量
    private int cacheSize;

    //带参数的构造器
    LRULinkedHashMap(int cacheSize) {
        //如果accessOrder为true的话，则会把访问过的元素放在链表后面，放置顺序是访问的顺序
        //如果accessOrder为flase的话，则按插入顺序来遍历
        super((int) Math.ceil(cacheSize / 0.75f) + 1, 0.75f, true);
        //传入指定的缓存最大容量
        this.cacheSize = cacheSize;
    }

    //实现LRU的关键方法，如果map里面的元素个数大于了缓存最大容量，则删除链表的顶端元素
    @Override
    public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<K, V> entry : this.entrySet()) {
            stringBuilder.append(String.format("[ %s : %s ]\n", entry.getKey(), entry.getValue()));
        }
        return stringBuilder.toString();
    }

    //test
    public static void main(String[] args) {
        LRULinkedHashMap<String, Integer> testCache = new LRULinkedHashMap<>(3);
        testCache.put("A", 1);
        testCache.put("B", 2);
        testCache.put("C", 3);
//        System.out.println(testCache.get("B"));
//        System.out.println(testCache.get("A"));
        testCache.put("D", 4);
        testCache.put("E", 5);
        System.out.println(testCache);
    }
}


