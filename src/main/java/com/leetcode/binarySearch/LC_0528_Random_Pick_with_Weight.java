/**
 * Created by Sijia on 1/11/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: binary search template
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.binarySearch;

import java.util.Random;

public class LC_0528_Random_Pick_with_Weight {
    int[] preSum;
    int sum;

    public void Solution(int[] w) {
        this.preSum = new int[w.length];
        this.sum = 0;

        for (int i = 0; i < w.length; i++) {
            this.sum += w[i];
            this.preSum[i] = sum;
        }
    }

    public int pickIndex() {
        int target = new Random().nextInt(sum) + 1;
        int start = 0, end = preSum.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target > this.preSum[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
