/**
 * Created by Sijia on 1/15/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: s and words[i] consist of only lowercase English letters.
 * <p> 1. 对于String S 每个char 在map里面找有没有对应的queue, then poll the first word, put the substring in the right queue
 * <p> 2. FIFO queue
 * <p> 3.
 */

package com.leetcode.subsequence;

import java.util.*;

public class LC_0792_Number_of_Matching_Subsequences {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, Queue<String>> map = new HashMap<>();
        int count = 0;

        for (char c = 'a'; c <= 'z'; c++) {
            map.putIfAbsent(c, new ArrayDeque<>());
        }

        for (String word: words) {
            map.get(word.charAt(0)).add(word);
        }

        for (char c: s.toCharArray()) {
            Queue<String> que = map.get(c);
            int size = que.size(); // need to save the size and loop because the size is changing
            while (size-- > 0) {
                String word = que.poll();
                if (word.length() == 1) {
                    count++;
                } else {
                    map.get(word.charAt(1)).add(word.substring(1));
                }
            }
        }
        return count;
    }
}
