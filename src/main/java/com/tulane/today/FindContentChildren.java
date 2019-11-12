package com.tulane.today;

import java.util.Arrays;

/**
 * Created by Tulane
 * 2019/11/6
 */
public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0, j = -1; i < g.length; i++) {
            while(true){
                j++;
                if(j >= s.length) return i;
                if(g[i] <= s[j]) break;
            }
        }
        return g.length;
    }
}
