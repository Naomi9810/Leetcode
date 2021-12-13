/**
 * Created by Sijia on 12/12/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. goes to the top, either from 2 steps or 1 steps
 * <p> 2. dp[n] = dp[n-1] + cost[n-1] + dp[n-2] + cost[n-2];
 * <p> 3.
 */

package com.goo.dp;

public class LC_0746_Min_Cost_Climbing_Stairs {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) return (Math.min(cost[0], cost[1]));
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n+1; i++) {
            dp[i] = Math.min (dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[n];
    }
}
