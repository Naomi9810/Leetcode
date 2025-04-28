/**
 * Created by Sijia on 12/15/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.dp;

public class LC_0213_House_Robber_II {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int[] dp1 = new int[len]; //  rob first house and skip second
        int[] dp2 = new int[len]; // skip first house and rob second
        dp1[1] = nums[0];

        for (int i = 2; i < len; i++) {
            dp1[i] = Math.max(nums[i - 1] + dp1[i - 2], dp1[i - 1]);
            dp2[i] = Math.max(nums[i - 1] + dp2[i - 2], dp2[i - 1]);
        }
        return Math.max(dp1[len - 1], dp2[len - 1]);

    }

}
