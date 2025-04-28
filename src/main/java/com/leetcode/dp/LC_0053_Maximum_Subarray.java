/**
 * Created by Sijia on 12/19/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. Kadane's Algorithm, max = Math.max( pre max + cur, cur)
 * <p> 2.
 * <p> 3. Now here in this question you can see that you can also be asked some more things like :
 * 1. Length of the max subarray
 * 2. Elements of the max subarray
 * 3. Start and End index of max subarray
 */

package com.leetcode.dp;

public class LC_0053_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int cur = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(cur + nums[i], nums[i]);
            max = Math.max(max, cur);
        }
        return max;
    }
}
