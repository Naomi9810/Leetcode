/**
 * Created by Sijia on 12/22/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. buy[i][j] = profit on day i with j transaction, when we are in buy state (holding a stock) on day i
 * <p> 2. sell[i][j] = profit on day i with j transaction, when we are in sell state (holding no stock) on day i
 * <p> 3.
 */

package com.goo.dp;

public class LC_0188_Best_Time_to_Buy_and_Sell_Stock_IV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;

        // on any day, we can be in one of the two states: buy or sell

        int[][] buy = new int[n][k+1];
        int[][] sell = new int[n][k+1];

        // when # of transaction = 0, we cannot make any profit on any day
        for (int i = 0; i < n; ++i) { // k == 0
            buy[i][0] = sell[i][0] = 0;
        }

        // on day 0, for all non-zero # of transaction
        for (int j = 1; j <= k; ++j) {
            buy[0][j] = -prices[0]; // we can make a purchase on day 0
            sell[0][j] = 0; // but we cannot sell on day 0
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= k; ++j) {
                buy[i][j] = Math.max(buy[i-1][j], sell[i-1][j-1] - prices[i]);
                // do nothing or buy on day i, means sell on day i-1 and operation j-1, buy will use operation, sell will not.

                sell[i][j] = Math.max(sell[i-1][j], buy[i-1][j] + prices[i]);
                // do nothing or sell on day i, already bought on day i-1
            }
        }
        return sell[n-1][k];
    }
}
