/**
 * Created by Sijia on 12/12/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. goes to the top, either from 2 steps or 1 steps
 * <p> 2. dp[n] = min (dp[n-1] + cost[n-1] ,dp[n-2] + cost[n-2]);
 * <p> 3.
 */

package com.goo.dp;

public class LC_0746_Min_Cost_Climbing_Stairs {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) return (Math.min(cost[0], cost[1]));
        int n = cost.length;
//        for (int i = 2; i < n; i++) {
//            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
//            // since we only use 3 parameter,which is dp[i], dp[i - 1], dp[i - 2] the space can be saved by using just 3 parameters
              // when i = 2 dp[1] = cost[1], dp[0] = cost[0]
//        }
//        return Math.min(dp[n - 1], dp[n - 2]);
        int oneStep = cost[1];
        int twoStep = cost[0];
        for (int i = 2; i < n; i++) {
            int cur = cost[i] + Math.min(oneStep, twoStep);
            twoStep = oneStep;
            oneStep = cur;
        }
        return Math.min(oneStep, twoStep);
    }
}
