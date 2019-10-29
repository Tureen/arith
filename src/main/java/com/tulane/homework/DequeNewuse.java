package com.tulane.homework;

import java.util.Deque;
import java.util.LinkedList;

/**
 *  重点: 旧代码为queue api(Deque继承自Queue), 遵循FILO规则
 *
First Element (Head)	                Last Element (Tail)
Throws  exception	    Special value	Throws exception	Special value
Insert	addFirst(e)	    offerFirst(e)	addLast(e)	        offerLast(e)
Remove	removeFirst()	pollFirst()	    removeLast()	    pollLast()
Examine	getFirst()	    peekFirst()	    getLast()	        peekLast()

 * Created by Tulane
 * 2019/10/20
 */
public class DequeNewuse {

    public static void main(String[] args) {
        wayOfOne();
        System.out.println("-----------------");
        wayOfTwo();
    }

    private static void wayOfOne() {
        Deque<String> deque = new LinkedList<>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        System.out.println(deque);

        String str = deque.getFirst();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size() > 0){
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }

    private static void wayOfTwo(){
        Deque<String> deque = new LinkedList<>();
        deque.offerLast("a");
        deque.offerLast("b");
        deque.offerLast("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size() > 0){
            System.out.println(deque.pollFirst());
        }
        System.out.println(deque);
    }
}
