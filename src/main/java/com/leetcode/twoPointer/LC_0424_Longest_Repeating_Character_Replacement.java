/**
 * Created by Sijia on 2/23/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.twoPointer;

public class LC_0424_Longest_Repeating_Character_Replacement {
    public int characterReplacement(String s, int k) {
        // longest substring with at most k distinct character
        if (s == null || s.length() == 0) return 0;
        if (k >= s.length()) return s.length();


        int[] letter = new int[26];
        int j = 0;
        int res = 1;
        int count =1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count = Math.max(count, ++letter[c - 'A']); // repeat char的 次数
            // invalid 移动左边window
            if (i - j + 1 - count > k ) {
                char remove = s.charAt(j);
                letter[remove - 'A']--;
                j++;
            }
            // valid 计算长度
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
