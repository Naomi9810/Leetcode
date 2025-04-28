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

package com.leetcode.binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC_0300_Longest_Increasing_Subsequence {
    public int lengthOfLIS(int[] nums) {
        List<Integer> sorted = new ArrayList<>();
        for (int n: nums) {
            if (sorted.isEmpty() || n > sorted.get(sorted.size()-1)) {
                sorted.add(n);
            } else {
                // binary search insert
                int idx = Collections.binarySearch(sorted, n);
                if (idx < 0) {
                    idx = -idx-1;
                    sorted.set(idx, n);
                } // if index >= 0, n is found in sorted, do nothing
            }
        }
        return sorted.size();
    }
}
