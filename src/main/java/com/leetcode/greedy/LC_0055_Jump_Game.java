/**
 * Created by Sijia on 12/18/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. choose from 1 - nums[i] jump steps
 * <p> 2.
 * <p> 3. start from the last step, and if the prev pos can go to this cell, then return true.
 */

package com.leetcode.greedy;

public class LC_0055_Jump_Game {
    public boolean canJump(int[] nums) {
        // corner case
//        if (nums.length == 1) return true;
//        if (nums[0] == 0 ) return false;
//
//        // start from i=0 -> i=nums.length-1
//        // steps = nums[i]
//        int len = nums.length;
//
//        boolean [] dp = new boolean[len]; // if we can jump to the index i
//        dp[0] = true;
//
//        for (int i = 0; i < len; i++) {
//            if (dp[i]) {
//                int steps = nums[i];
//                for (int j = 0; j <= steps; j++) {
//                    int next = i + j;
//                    if (next == len - 1) {
//                        return true;
//                    } else if (next < len - 1 && !dp[next]) {
//                        dp[next] = true;
//                    }
//                }
//            }
//
//        }
//        return dp[len-1]; // dp working solution n2 time complexity

        int farthest = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i > farthest) {
                return false;
            } // must check first, why because if we can't reach i, we can't jump
            farthest = Math.max(farthest, i + nums[i]);

        }
        return true;
    }
}
