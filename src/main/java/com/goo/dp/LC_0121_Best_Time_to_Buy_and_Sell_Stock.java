/**
 * Created by Sijia on 12/20/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.dp;

public class LC_0121_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, prices[i] - min); // find a pre min
            min = Math.min(min, prices[i]); // update afterwards
        }
        return max;
    }
}
