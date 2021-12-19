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

package com.goo.greedy;

public class LC_0055_Jump_Game {
    public boolean canJump(int[] nums) {
//        int len = nums.length;
//        if (len == 1) return true;
//        if (nums[0] == 0) return false;
//        boolean[] dp = new boolean[len];
//        dp[len - 1] = true;
//        for (int i = len - 2; i >= 0; i--) {
//            for (int j = 0; j <= nums[i] && i + j < len; j++) {
//                if (dp[i + j]) {
//                    dp[i] = true;
//                    break;
//                }
//            }
//        }
//        return dp[0];
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        // jump as far as you can, if lastPos <= 0 then we can jump back.
        return lastPos == 0;
    }
}
