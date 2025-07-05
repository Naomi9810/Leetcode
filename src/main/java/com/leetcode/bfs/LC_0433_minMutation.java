package com.leetcode.bfs;

import java.util.*;


public class LC_0433_minMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene))
            return -1;

        char[] replace = new char[] { 'A', 'C', 'G', 'T' };
        Queue<String> que = new ArrayDeque<>();
        que.add(startGene);
        int step = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                String cur = que.remove();
                if (cur.equals(endGene))
                    return step;

                for (int i = 0; i < cur.length(); i++) {
                    char[] chars = cur.toCharArray();
                    for (char c : replace) {
                        if (chars[i] == c)
                            continue;
                        chars[i] = c;
                        String nxt = new String(chars);

                        if (bankSet.contains(nxt)) {
                            que.add(nxt);
                            bankSet.remove(nxt); // Mark as visited
                        }
                    }
                }
            }
            step++;
        }

        return -1;
    }
}
