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

package com.goo.dp;

public class LC_0053_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int max = dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
           dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
           if (dp[i] > max) {
               max = dp[i];
           }
        }
        return max;
    }
}
