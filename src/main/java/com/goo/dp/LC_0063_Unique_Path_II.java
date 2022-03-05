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

public class LC_0063_Unique_Path_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        Integer[][] dp = new Integer[m][n];
        return uniquePathsHelper(m-1, n-1, dp, obstacleGrid);

    }

    public int uniquePathsHelper(int m, int n, Integer[][] dp, int[][] obstacleGrid) {

        if (m < 0 || n < 0) return 0;
        if (obstacleGrid[m][n] == 1) {
            return 0;
        }
        if (dp[m][n] != null) {
            return dp[m][n];
        }
        if (m == 0 && n == 0) {
            dp[m][n] = 1;
        } else {
            dp[m][n] = uniquePathsHelper(m-1, n, dp,obstacleGrid) + uniquePathsHelper(m, n-1, dp, obstacleGrid);

        }
        return dp[m][n] ;
    }
}
