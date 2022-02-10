/**
 * Created by Sijia on 2/4/22
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

import java.util.HashMap;
import java.util.Map;

public class LC_1218_Longest_Arithmetic_Subsequence_of_Given_Difference {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 1;
        for (int num : arr) {
            int pre = num - difference;
            count.put(num, count.getOrDefault(pre, 0) + 1);
            res = Math.max(res, count.get(num));
        }
        return res;
    }
}
