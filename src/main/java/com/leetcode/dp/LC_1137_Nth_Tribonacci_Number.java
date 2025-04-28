/**
 * Created by Sijia on 12/12/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.dp;

public class LC_1137_Nth_Tribonacci_Number {
    public int tribonacci(int n) {
//        if (n == 0) return 0;
//        else if (n <= 2) return 1;
//        int res = 0;
//        int pre1 = 0;
//        int pre2 = 1;
//        int pre3 = 1;
//        for (int i = 2; i < n; i++) {
//            res = pre1 + pre2 + pre3;
//            pre1 = pre2;
//            pre2 = pre3;
//            pre3 = res;
//        }
//        return res;
        int[] dp = {0, 1, 1};
        for (int i = 3; i <= n; i++) {
            dp[i % 3] = dp[0] + dp[1] + dp[2];
        }
        return dp[n % 3];
    }
}
