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

package com.leetcode.dp;

public class LC_0063_Unique_Path_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        int[] dp = new int[col];

        // Initialize the starting point
        if (obstacleGrid[0][0] == 1 || obstacleGrid[row-1][col-1] == 1)return 0;
        dp[0] = 1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0; // No path through obstacle
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[col - 1];
    }


}
