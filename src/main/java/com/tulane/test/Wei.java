package com.tulane.test;

/**
 * Created by Tulane
 * 2019/12/1
 */
public class Wei {

    public static void main(String[] args) {
        int x = 8721;
        while((x&-x) != 0){
            System.out.println((x&-x));
            x=x&(x-1);
        }

    }
}
