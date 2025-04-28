/**
 * Created by Sijia on 12/21/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:  pay the fee when selling the stock
 * <p> 1.  same concept as LC_309
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.dp;

public class LC_0714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int [] buy = new int[len], sell = new int[len];
        buy[0] = - prices[0];
        for (int i = 1; i < len; i++) {
            buy[i] = Math.max(buy[i-1], sell[i-1] - prices[i]); //  do nothing or buy at i
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i] - fee); // do nothing or sell at i
        }
        return sell[len-1];
    }
}
