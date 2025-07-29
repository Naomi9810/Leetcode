package com.leetcode.dp;

import java.util.Arrays;

public class LC_0322_Coin_Change {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // amount+1 is safe upper bound
        dp[0] = 0;

        // choose a coin and calculate the dp value,  [coin: amount]
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1: dp[amount];
    }
}
