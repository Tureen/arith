package com.tulane.today;

import java.util.HashMap;

/**
 * LRU缓存
 * hashmap + 双向链表
 * 定义容量, 定义hashmap value的类, 包含前驱后继节点
 * Created by Tulane
 * 2019/10/16
 */
public class LRUCacheToday<K, V> {

    private final int capacity;

    private HashMap<K, Entry> map;
    private Entry head;
    private Entry tail;

    public LRUCacheToday(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>((int)(capacity / 0.75) + 1, 0.75f);
        head = new Entry();
        tail = new Entry();
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key){
        if(map.containsKey(key)){
            Entry entry = map.get(key);
            addToTail(entry);
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
            if(map.size() >= this.capacity){
                Entry first = popToRemove();
                map.remove(first.key);
            }
            addToTail(entry);
            map.put(key, entry);
        }
    }

    class Entry{
        private K key;
        private V value;
        private Entry prev;
        private Entry next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Entry() {
        }
    }

    public void addToTail(Entry entry){
        Entry last = tail.prev;
        last.next = entry;
        entry.prev = last;
        entry.next = tail;
        tail.prev = entry;
    }

    public void popToTail(Entry entry){
        Entry prevEntry = entry.prev;
        Entry nextEntry = entry.next;
        prevEntry.next = entry;
        nextEntry.prev = prevEntry;

        addToTail(entry);
    }

    public Entry popToRemove(){
        Entry first = head.next;
        Entry second = first.next;
        head.next = second;
        second.prev = head;
        return first;
    }

    public static void main(String[] args) {
        LRUCacheToday<Integer, Integer> cache = new LRUCacheToday<>(2);
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
