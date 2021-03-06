package com.tulane.leetcode.four;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tulane
 * 2019/12/10
 */
public class LeetCode_146 {

    private int capacity;
    private Map<Integer, Entry> map;
    private Entry head;
    private Entry tail;

    public LeetCode_146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>((int) (capacity / 0.75), 0.75f);
        head = new Entry();
        tail = new Entry();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Entry entry = map.get(key);
            popToTail(entry);
            return entry.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Entry entry = map.get(key);
            entry.value = value;
            popToTail(entry);
        } else {
            Entry entry = new Entry(key, value);
            if (map.size() >= capacity) {
                Entry first = popHead();
                map.remove(first.key);
            }
            addToTail(entry);
            map.put(key, entry);
        }
    }

    class Entry {
        private int key;
        private int value;
        private Entry prev;
        private Entry next;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Entry() {
        }
    }

    private void addToTail(Entry entry) {
        Entry last = tail.prev;
        last.next = entry;
        tail.prev = entry;
        entry.prev = last;
        entry.next = tail;
    }

    private void popToTail(Entry entry) {
        Entry prevEntry = entry.prev;
        Entry nextEntry = entry.next;
        prevEntry.next = nextEntry;
        nextEntry.prev = prevEntry;
        addToTail(entry);
    }

    private Entry popHead() {
        Entry first = head.next;
        Entry second = first.next;
        head.next = second;
        second.prev = head;
        return first;
    }
}
