/**
 * Created by Sijia on 12/20/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. you can choose buy/cool down/sell at each day
 * <p> 2. buy[i] : max profit of days [0...i], and the last operation is "buy"(might or might not buy on day i)
 * <p> 3. sell[i] -- max profit of days [0...i], and the last operation is "sell"(might or might not sell on day i).
 * buy at i then i-1 must be cool down, can't be buy-buy or sell-buy
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75931/Easiest-JAVA-solution-with-explanations
 */

package com.leetcode.dp;

public class LC_309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    public int maxProfit(int[] prices) {
        // corner case
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        if (len < 2) return 0;

        // buy, cool down, sell
        int[] buy = new int[len]; // max profit day i to buy
        int[] sell = new int[len]; // max profit day i to sell

        buy[0] = -prices[0];
        buy[1] = Math.max(buy[0], -prices[1]);
        sell[0] = 0;
        sell[1] = Math.max(sell[0], prices[1] - prices[0]);

        for (int i = 2; i < len; i++) {
            buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]); // if I buy today, last day must be cool down, i-2 is sell
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]); // buy last time
        }
        return sell[len-1];
    }
}
