/**
 * Created by Sijia on 4/2/22
 * Time Complexity:
 * <p> average OlogN worst case O(N^2)
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.mathBitMatrix;

import java.util.HashSet;
import java.util.Set;

public class LC_1763_Longest_Nice_Substring {
    // divide and conquer
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";
        char[] charArr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : charArr) {
            set.add(c);
        }
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            if (set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c))) continue;
            String sub1 = longestNiceSubstring(s.substring(0, i));
            String sub2 = longestNiceSubstring(s.substring(i + 1));
            return sub1.length() >= sub2.length() ? sub1 : sub2;
        }
        return s;
    }
}
