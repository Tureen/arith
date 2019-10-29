package com.tulane.mine;

import java.util.HashMap;

/**
 * Created by Tulane
 * 2019/10/16
 */
public class LRUCacheDo<K, V> {

    private final int capacity;
    private HashMap<K, Entry> map;
    private Entry head;
    private Entry tail;

    public LRUCacheDo(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>((int)(capacity / 0.75), 0.75f);
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
        //将末尾节点last取出
        Entry last = tail.prev;
        last.next = entry;
        entry.prev = last;
        entry.next = tail;
        tail.prev = entry;
    }

    public void popToTail(Entry entry){
        //断开前驱后继节点联系
        Entry prevEntry = entry.prev;
        Entry nextEntry = entry.next;
        prevEntry.next = nextEntry;
        nextEntry.prev = prevEntry;

        //将节点加入到尾部
        addToTail(entry);
    }

    public Entry popToRemove(){
        //将头结点指向的节点提出
        Entry first = head.next;
        Entry second = first.next;
        head.next = second;
        second.prev = head;
        return first;
    }

    public static void main(String[] args) {
        LRUCacheDo<Integer, Integer> cache = new LRUCacheDo<>(2);
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
