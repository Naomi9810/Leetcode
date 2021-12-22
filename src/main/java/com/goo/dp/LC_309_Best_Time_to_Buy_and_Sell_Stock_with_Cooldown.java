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

package com.goo.dp;

public class LC_309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        if (len < 2) return 0;
        int[] buy = new int[len];
        int[] sell = new int[len];
        buy[0] = -prices[0]; //  can only buy at day 1
        buy[1] = -Math.min(prices[0], prices[1]); //  choose buy day 1 or 2 whichever is cheaper
        sell[1] = Math.max(0, prices[1] - prices[0]);// possible max profit in day 2

        for (int i = 2; i < len; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]); // wait or buy at i, i-1 is cool down
            sell[i] = Math.max(sell[i - 1], prices[i] + buy[i - 1]);
            // wait or sell what bought in i-1, note we can do buy-sell so i is sell, i-1 is buy
        }
        return sell[len-1];
    }
}
