/**
 * Created by Sijia on 12/20/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 买卖股票系列总结
 * <p> 1 - one time buy+sell->  find the pre min, then find a max
 * <p> II .- unlimited buy+sell -> greedy, add all the profits
 * <P> III. - only 2 times buy+sell -> same as 1. but with 2 variable buy1, buy2, sell1, sell2
 * <P> IV. - only k times buy+sell -> buy[i][k] sell[i][k]
 * <P> with cool down  -> buy[], sell[]
 * <P> with fee  -> buy[], sell[]
 */

package com.leetcode.dp;

import com.leetcode.greedy.LC_0122_Best_Time_to_Buy_and_Sell_Stock_II;
import com.leetcode.dp.LC_0123_Best_Time_to_Buy_and_Sell_Stock_III;
import com.leetcode.dp.LC_0188_Best_Time_to_Buy_and_Sell_Stock_IV;
import com.leetcode.dp.LC_309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;


public class LC_0121_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        for (int price: prices) {
            if (price < min) {
                // keep track of the lowest
                min =  price;
            } else if (price - min > max) {
                max = price - min;
            }
        }
        return max;
    }
}
