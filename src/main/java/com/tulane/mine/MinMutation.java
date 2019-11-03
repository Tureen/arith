package com.tulane.mine;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。

 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。

 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。

 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。

 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。

 注意:

 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 所有的目标基因序列必须是合法的。
 假定起始基因序列与目标基因序列是不一样的。

 */

public class MinMutation {

    public static void main(String[] args) {
        String start  ="AACCGGTT";
        String end  ="AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        new MinMutation().minMutation(start, end, bank);
    }

    /**
     * 网上的解
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;

        Set<String> bankSet = new HashSet<>();
        for(String b: bank) bankSet.add(b);

        char[] charSet = new char[]{'A', 'C', 'G', 'T'};

        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                String curr = queue.poll();
                if(curr.equals(end)) return level;

                char[] currArray = curr.toCharArray();
                for(int i = 0; i < currArray.length; i++) {
                    char old = currArray[i];
                    for(char c: charSet) {
                        currArray[i] = c;
                        String next = new String(currArray);
                        if(!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    currArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }
}
