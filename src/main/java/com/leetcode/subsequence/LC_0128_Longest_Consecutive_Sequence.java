/**
 * Created by Sijia on 3/1/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.subsequence;

import java.util.HashSet;
import java.util.Set;

public class LC_0128_Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int maxLen = 1;
        for (int n : set) {
            if (!set.contains(n - 1)) { // 关键不能double count 只从最小的开始
                int len = 1;
                while (set.contains(++n)) {
                    len++;
                    maxLen = Math.max(len, maxLen);
                }
            }
        }
        return maxLen;
    }
}
