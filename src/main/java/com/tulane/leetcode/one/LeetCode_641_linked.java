package com.tulane.leetcode.one;

/**
 * 设计循环双端队列
 */
public class LeetCode_641_linked {

    private Node head;
    private Node tail;

    private int capacity;
    private int size;


    /** Initialize your data structure here. Set the size of the deque to be k. */
    public LeetCode_641_linked(int k) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        capacity = k;
        size = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        size++;
        addToHead(new Node(value));
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        size++;
        addToTail(new Node(value));
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        size--;
        popFromHead();
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        size--;
        popFromTail();
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        Node node = peekForHead();
        return node.value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        Node node = peekForTail();
        return node.value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size <= 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size >= capacity;
    }

    class Node {

        private Node prev;
        private Node next;
        private int value;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }
    }

    public void addToHead(Node node){
        Node first = head.next;
        first.prev = node;
        node.next = first;
        head.next = node;
        node.prev = head;
    }

    public void addToTail(Node node){
        Node last = tail.prev;
        last.next = node;
        node.prev = last;
        tail.prev = node;
        node.next = tail;
    }

    public Node peekForHead(){
        return head.next;
    }

    public Node peekForTail(){
        return tail.prev;
    }

    public Node popFromHead(){
        Node first = head.next;
        Node second = first.next;
        head.next = second;
        second.prev = head;
        first.prev = null;
        first.next = null;
        return first;
    }

    public Node popFromTail(){
        Node last = tail.prev;
        Node prevLast = last.prev;
        prevLast.next = tail;
        tail.prev = prevLast;
        last.prev = null;
        last.next = null;
        return last;
    }
}
