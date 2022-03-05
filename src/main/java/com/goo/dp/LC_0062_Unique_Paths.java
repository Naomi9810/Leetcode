/**
 * Created by Sijia on 3/3/22
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

public class LC_0062_Unique_Paths {
    public int uniquePaths(int m, int n) {
        Integer[][] dp = new Integer[m+1][n+1];
        return uniquePathsHelper(m, n, dp);

    }

    public int uniquePathsHelper(int m, int n, Integer[][] dp) {

        if (m < 0 || n < 0) return 0;
        if (dp[m][n] != null) {
            return dp[m][n];
        }
        if (m == 1 || n == 1) {
            dp[m][n] = 1;
        } else {
            dp[m][n] = uniquePathsHelper(m-1, n, dp) + uniquePathsHelper(m, n-1, dp);

        }
        return dp[m][n] ;
    }
}
