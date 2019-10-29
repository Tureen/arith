package com.tulane.copy;

import java.util.HashMap;

/**
 * Hashmap + 双向链表 的结构
 * hashmap保证随机读取为O(1), 双向链表按时间正序(约后的时间越近), 用于空间不够时删除最早访问
 * Created by Tulane
 * 2019/10/15
 */
public class LRUCache<K, V> {


    private final int capacity;
    private HashMap<K, Entry> map;
    private Entry head;
    private Entry tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        /**
         * capacity/0.75 保证当前capacity大小的hashmap不会自动扩容
         */
        map = new HashMap<>((int)(capacity / 0.75 + 1), 0.75f);
        head = new Entry();
        tail = new Entry();
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key){
        if(map.containsKey(key)){
            Entry entry = map.get(key);
            popToTail(entry);
            return entry.value;
        }
        return null;
    }

    public void put(K key, V value){
        if(map.containsKey(key)){
            Entry entry = map.get(key);
            entry.value = value;
            popToTail(entry);
        }else{
            Entry entry = new Entry(key, value);
            if(map.size() >= capacity){
                Entry removeEntry = removeFirst();
                map.remove(removeEntry.key);
            }
            addToTail(entry);
            map.put(key, entry);
        }
    }


    class Entry{
        /**
         * 记录映射的hashmap的key. 在剔除头结点阶段可快速定位具体hashmap
         */
        private K key;
        /**
         * 存入实际值
         */
        private V value;
        private Entry next;
        private Entry prev;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Entry() {
        }
    }

    /**
     * 添加节点至末端
     * @param entry
     */
    private void addToTail(Entry entry){
        Entry lastEntry = tail.prev;
        lastEntry.next = entry;
        entry.prev = lastEntry;

        entry.next = tail;
        tail.prev = entry;
    }

    /**
     * 将已有节点移至末尾
     * @param entry
     */
    private void popToTail(Entry entry){
        Entry prevEntry = entry.prev;
        Entry nextEntry = entry.next;
        prevEntry.next = nextEntry;
        nextEntry.prev = prevEntry;

        addToTail(entry);
    }

    /**
     * 首端结点出列
     * @return
     */
    private Entry removeFirst(){
        Entry first = head.next;
        Entry second = first.next;
        head.next = second;
        second.prev = head;
        return first;
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache = new LRUCache<>(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }
}
