/**
 * Created by Sijia on 12/13/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. dp[i] = Math.max(take 3, take2, take1)
 * <p> 2. calculate the alice total and Bob total then return the bigger one
 * <p> 3.
 */

package com.leetcode.dp;

public class LC_1406_Stone_Game_III {
    public String stoneGameIII(int[] stoneValue) {
        int len = stoneValue.length;
        int[] dp = new int[len + 1]; //  dp present this round the max points, 0 is Alice, 1 is Bob and so one
        for (int i = len - 1; i >= 0; i--) {
            int sum = 0;
            dp[i] = Integer.MIN_VALUE; // initiate the value
            for (int k = 0; k < 3 && i + k < len; k++) {
                sum += stoneValue[i + k]; // take has 3 options
                dp[i] = Math.max(dp[i], sum - dp[i + k + 1]);
                // calculate this round take - next round max take, find the max, Alice needs to consider Bob's move
            }
        }
        if (dp[0] > 0) return "Alice"; //  dp[0] is Alice is winner
        if (dp[0] < 0) return "Bob";
        return "Tie";


    }
}
