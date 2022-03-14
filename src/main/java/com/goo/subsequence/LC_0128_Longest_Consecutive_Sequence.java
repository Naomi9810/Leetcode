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

package com.goo.subsequence;

import java.util.HashSet;
import java.util.Set;

public class LC_0128_Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n: nums) {
            set.add(n);
        }
        int res = 0;

        for (int n: set) {
            if (!set.contains(n-1)) { // 关键不能double count 只从最小的开始
                int cur = n;
                int len = 1;
                while (set.contains(cur+1)) {
                    cur++;
                    len++;
                }
                res = Math.max(res, len);
            }
        }
        return res;
    }
}
