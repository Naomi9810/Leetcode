/**
 * Created by Sijia on 12/22/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 */

package com.leetcode.dp;

public class LC_0188_Best_Time_to_Buy_and_Sell_Stock_IV {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;

        if (k >= len/2) {
            // same as unlimited, using a greedy approach
            int min = prices[0];
            int max = 0;
            for (int price:  prices) {
                if (price - min > 0) {
                    max += price - min;
                }
                min = price;

            }
            return max;
        }

        int[][] dp = new int[len][k+1]; //  the max profit we can make at day len and k transaction
        // day 0 to day k, len is k+1
        dp[0][0] = 0;

        // i is day, j is transaction
        for (int j= 1; j < k+1; j++) {
            int earn = -prices[0];
            // have to loop the days inside
            for (int i = 1; i < len; i++) {
                dp[i][j] = Math.max(dp[i-1][j], prices[i] + earn); // hold vs sell
                earn = Math.max(earn, dp[i][j-1] - prices[i]); // hold vs buy
            }


        }

        return dp[len-1][k];
    }
}
