/**
 * Created by Sijia on 2/15/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p>
 * https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/discuss/516940/Simple-Java-DP
 * __ P1 __ P2 __ D1 __ D2 __
 * <p>
 * If we place (P3 D3) at space 1 : we can have five combinations: 5
 * If we place (P3 D3) at space 2 : we can have four combinations: 4
 * If we place (P3 D3) at space 3 : we can have three combinations: 3
 * If we place (P3 D3) at space 4 : we can have two combinations: 2
 * If we place (P3 D3) at space 5 : we can have two combinations: 1
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.dp;

public class LC_1395_Count_All_Valid_Pickup_and_Delivery_Options {
    public int countOrders(int n) {
        int mod = (int) (Math.pow(10, 9) + 7);
        long[] dp = new long[501];
        dp[1] = 1;
        dp[2] = 6;

        for (int i = 3; i <= n; i++) {
            int space = (i - 1) * 2 + 1;
            long val = space * (space + 1) / 2;
            dp[i] = (dp[i - 1] * val) % mod;
        }

        return (int) dp[n];
    }
}
