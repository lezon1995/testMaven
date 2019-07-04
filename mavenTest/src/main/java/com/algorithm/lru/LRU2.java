package com.algorithm.lru;


import java.util.HashMap;

/**
 * 使用cache和链表实现缓存
 */
public class LRU2<K, V> {
    private final int MAX_CACHE_SIZE;
    private Entry<K, V> head;
    private Entry<K, V> tail;

    private HashMap<K, Entry<K, V>> cacheMap;

    public LRU2(int cacheSize) {
        MAX_CACHE_SIZE = cacheSize;
        cacheMap = new HashMap<>();
    }

    public void put(K key, V value) {
        Entry<K, V> entry = getEntry(key);
        //如果是新添加的元素
        if (entry == null) {
            //如果缓存大小>=最大指定大小
            if (cacheMap.size() >= MAX_CACHE_SIZE) {
                cacheMap.remove(tail.key);
                //去掉尾节点
                removeTail();
            }
            //创建新节点
            entry = new Entry<>();
            entry.key = key;
            entry.value = value;
            //就把它放在头结点
            moveToHead(entry);
            //并且添加到缓存中
            cacheMap.put(key, entry);
        } else {
            //如果是缓存中已经存在的元素 则直接赋值
            entry.value = value;
            //并且将其移动到头节点
            moveToHead(entry);
        }
    }

    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) {
            return null;
        }
        moveToHead(entry);
        return entry.value;
    }

    public void remove(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry != null) {
            if (entry == head) {
                Entry<K, V> next = head.next;
                head.next = null;
                head = next;
                head.pre = null;
            } else if (entry == tail) {
                Entry<K, V> prev = tail.pre;
                tail.pre = null;
                tail = prev;
                tail.next = null;
            } else {
                entry.pre.next = entry.next;
                entry.next.pre = entry.pre;
            }
            cacheMap.remove(key);
        }
    }

    private void removeTail() {
        if (tail != null) {
            Entry<K, V> prev = tail.pre;
            if (prev == null) {
                head = null;
                tail = null;
            } else {
                tail.pre = null;
                tail = prev;
                tail.next = null;
            }
        }
    }

    private void moveToHead(Entry<K, V> entry) {
        if (entry == head) {
            return;
        }
        if (entry.pre != null) {
            entry.pre.next = entry.next;
        }
        if (entry.next != null) {
            entry.next.pre = entry.pre;
        }
        if (entry == tail) {
            Entry<K, V> prev = entry.pre;
            if (prev != null) {
                tail.pre = null;
                tail = prev;
                tail.next = null;
            }
        }

        if (head == null || tail == null) {
            head = tail = entry;
            return;
        }

        entry.next = head;
        head.pre = entry;
        entry.pre = null;
        head = entry;
    }

    private Entry<K, V> getEntry(K key) {
        return cacheMap.get(key);
    }

    private static class Entry<K, V> {
        Entry<K, V> pre;
        Entry<K, V> next;
        K key;
        V value;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Entry<K, V> entry = head;
        stringBuilder.append("head >> ");
        while (entry != null) {
            stringBuilder.append(String.format("%s:%s ", entry.key, entry.value));
            entry = entry.next;
        }
        stringBuilder.append(" >> tail");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LRU2<Integer, Integer> lru2 = new LRU2<>(5);
        lru2.put(1, 1);
        System.out.println(lru2);
        lru2.put(2, 2);
        System.out.println(lru2);
        lru2.put(3, 3);
        System.out.println(lru2);
        lru2.get(1);
        System.out.println(lru2);
        lru2.put(4, 4);
        lru2.put(5, 5);
        lru2.put(6, 6);
        System.out.println(lru2);
    }
}