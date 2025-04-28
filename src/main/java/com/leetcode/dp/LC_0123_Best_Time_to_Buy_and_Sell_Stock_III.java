/**
 * Created by Sijia on 12/22/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: buy1, sell1, buy2, sell2, same logic as 121 just repeat the process for twice
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.dp;

public class LC_0123_Best_Time_to_Buy_and_Sell_Stock_III {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int buy1 = prices[0], buy2 = prices[0];
        int sell1 = 0, sell2 = 0;
        for (int i = 1; i < len; i++) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max (sell1, prices[i] - buy1);
            // buy the second time
            buy2 = Math.min(buy2, prices[i] - sell1); // earned in sell1, so the cost decreased
            sell2 = Math.max(sell2, prices[i] - buy2);
        }
        return sell2;
    }
}
