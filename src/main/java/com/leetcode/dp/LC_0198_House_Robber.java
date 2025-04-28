/**
 * Created by Sijia on 12/15/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. rob i , we can only rob i-2
 * <p> 2. not rob i, then we can choose rob i-1
 * <p> 3. why this is i-2, i-1 because we only know dp[0] and dp[1],
 */

package com.leetcode.dp;

public class LC_0198_House_Robber {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        if (len == 1) {
            return dp[0];
        }

        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
           dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[len - 1];
    }
}
