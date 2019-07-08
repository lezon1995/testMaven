package com.algorithm.lru;


import java.util.HashMap;

/**
 * 使用cache和链表实现缓存
 */
public class LRU2<K, V> {
    /**
     * 最大缓存大小
     */
    private final int MAX_CACHE_SIZE;
    /**
     * 头结点
     */
    private Entry<K, V> head;
    /**
     * 尾节点
     */
    private Entry<K, V> tail;

    /**
     * 缓存map
     */
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
                //从缓存中删除尾节点的元素
                cacheMap.remove(tail.key);
                //去掉尾节点
                removeTail();
            }
            //创建新节点
            entry = new Entry<>();
            entry.key = key;
            entry.value = value;
            //将每次新增的节点都放到头结点
            moveToHead(entry);
            //并且添加到缓存中
            cacheMap.put(key, entry);
        } else {
            //如果是缓存中已经存在的元素 则直接赋值
            entry.value = value;
            //将每次新增的节点都放到头结点
            moveToHead(entry);
        }
    }

    /**
     * 根据键获取值
     *
     * @param key
     * @return
     */
    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) {
            return null;
        }
        //将每次操作过的节点放到头结点位置
        moveToHead(entry);
        return entry.value;
    }

    /**
     * 移除当前Key
     *
     * @param key
     */
    public void remove(K key) {
        //获取当前Key的Value
        Entry<K, V> entry = getEntry(key);
        //如果value存在
        if (entry != null) {
            //如果value为头结点
            if (entry == head) {
                Entry<K, V> next = head.next;
                //让当前头结点的下一个节点为空
                head.next = null;
                //让之前头结点的下一个节点为新的头结点
                head = next;
                //让当前头结点的前一个节点为空
                head.pre = null;
            } else if (entry == tail) {//如果当前需要删除的节点为尾节点
                Entry<K, V> prev = tail.pre;
                //让当前尾节点的前一个节点为空
                tail.pre = null;
                //让旧的尾节点的前一个节点为新的尾节点
                tail = prev;
                //让当前尾节点的下一个节点为空
                tail.next = null;
            } else {//如果当前需要删除的节点为中间节点
                //直接让当前删除的节点的上一个节点的next指向当前删除的节点的下一个节点
                entry.pre.next = entry.next;
                //直接让当前删除的节点的下一个节点的pre指向当前删除的节点的上一个节点
                entry.next.pre = entry.pre;
            }
            //从缓存map中删除该键
            cacheMap.remove(key);
        }
    }

    /**
     * 移除尾节点
     */
    private void removeTail() {
        //如果尾节点不为空
        if (tail != null) {
            //让尾节点的前一个节点=prev
            Entry<K, V> prev = tail.pre;
            //如果尾节点的前一个节点为空 说明整个链表就一个节点
            if (prev == null) {
                //让头尾节点都为空
                head = null;
                tail = null;
            } else {
                //如果尾节点的前一个节点不为空
                //让尾节点与前一个节点断开
                tail.pre = null;
                //让prev为当前链表的尾节点
                tail = prev;
                //让prev的下一个节点为空(之前引用着已经删除了的尾节点)
                tail.next = null;
            }
        }
    }

    /**
     * 将参数节点放到头结点
     * 此时置于尾端的节点就是访问次数最少的节点 应该被淘汰掉
     * 符合LRU算法思想
     *
     * @param entry 参数节点
     */
    private void moveToHead(Entry<K, V> entry) {
        //如果当前节点已经为头结点 直接结束
        if (entry == head) {
            return;
        }
        //如果当前头尾节点都为空 说明整个链表为空
        if (head == null || tail == null) {
            //即让头尾节点都为当前节点entry
            head = tail = entry;
            return;
        }

        //如果当前节点的前一个节点不为空
        if (entry.pre != null) {
            //让当前节点的前一个节点的next指向当前节点的下一个节点
            // 比如 A->-B->C 现在将B移到头结点 那么B与A C断开 即为 A->C
            entry.pre.next = entry.next;
        }
        //如果当前节点的下一个节点不为空
        if (entry.next != null) {
            //让当前节点的下一个节点的pre指向当前节点的前一个节点
            entry.next.pre = entry.pre;
        }
        //如果当前节点即为尾节点
        if (entry == tail) {
            //让prev为尾节点的前一个节点
            Entry<K, V> prev = entry.pre;
            //如果尾节点的前一个节点不为空
            if (prev != null) {
                //让尾节点的前一个节点为空
                tail.pre = null;
                //让prev为当前尾节点
                tail = prev;
                //让prev的下一个节点为空
                tail.next = null;
            }
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