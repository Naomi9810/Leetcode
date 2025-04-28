/**
 * Created by Sijia on 3/5/22
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

public class LC_0340_Longest_Substring_AtMost_K_Distinct_Characters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // similar to 424
        // longest substring with at most k distinct character
        if (s == null || s.length() == 0) return 0;
        if (k == s.length()) return k;

        int[] map = new int[256];
        int distinct = 0, start = 0, len = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map[c] == 0) {
                distinct++;
            }
            map[c]++;
            while (distinct > k) {
                char remove = s.charAt(start);
                map[remove]--;
                if (map[remove] == 0) {
                    distinct--;
                }
                start++;
            }
            len = Math.max(len, i - start + 1);

        }
        return len;

    }
}
