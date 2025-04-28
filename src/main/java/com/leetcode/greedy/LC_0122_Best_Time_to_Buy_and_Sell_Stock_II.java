/**
 * Created by Sijia on 12/20/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. each day you can have 3 options, buy, do nothing and sell
 * <p> 2. if buy we have int pre = prices[i] and you can't buy util you sell it.
 * <p> 3. using greedy to calculate only need to look the pre
 */

package com.leetcode.greedy;

public class LC_0122_Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int pre = prices[0];
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > pre) {
                res += prices[i] - pre;
            }
            pre = prices[i];
        }
        return res;
    }
}
