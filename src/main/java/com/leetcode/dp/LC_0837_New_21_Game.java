/**
 * Created by Sijia on 12/23/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. dp[i] is the probability that we get points i at some moment.
 * In another word: 1 - dp[i]is the probability that we skip the points i.
 * <p> 2. dp[i] = sum(last maxPts dp values) / maxPts
 * <p> 3.
 */

package com.leetcode.dp;

public class LC_0837_New_21_Game {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || maxPts + k - 1 <= n) return 1.0;
        // any card will exceed k, so always <= n
        // if the max point you can get during the game <= n, the always <= n

        double[] dp = new double[n + 1]; // dp[i] represents the possibility of reaching i
        dp[0] = 1; //  same as k == 0;
        double base = 1.0 / maxPts; // the possibility to picking any number [1, maxPts]
        // then dp[i] = (p[i - 1] + p[i - 2] + p[i - 3] + ... p[i - maxPts]) * 1 / maxPts
        double sum = 0, res = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = sum * base + (i <= maxPts ? base : 0);
            if (i < k) {
                sum += dp[i]; // continue
            }
            if ( i > maxPts) {
                sum -= dp[i-maxPts];
            }
            if (i >= k) {
                res += dp[i];
            }
        }
        return res;
    }
}
