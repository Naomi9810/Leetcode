/**
 * Created by Sijia on 4/30/22
 * Time Complexity:
 * Space Complexity:
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.mathBitMatrix;

import java.util.HashSet;
import java.util.Set;

public class LC_2135_Count_Words_Obtained_After_Adding_a_Letter {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> startSet = new HashSet<>();
        for (String s : startWords) {
            startSet.add(toBinary(s));
        }

        int res = 0;
        for (String word : targetWords) {
            int curr = toBinary(word);
            for (int i = 0; i < 26; i++) {
                int mask = 1 << i; // this letter
                if ((curr & mask) > 0) { // contain this letter
                    int tmp = curr - mask; // remove this letter
                    if (startSet.contains(tmp)) {
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }


    public int toBinary(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            res += (1 << (c - 'a'));
        }
        return res;
    }
}
