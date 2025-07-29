package com.leetcode.dp;

public class LC_0064_Minimum_Path_Sum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        // start from grid[0][0] => grid[row-1][col-1];
        // every step i,j,
        // i+1, j
        // i, j+1
        // i+1, j+1
        // i+1 is from i
        //

        int[][] dp =  new int[row][col]; // each value represent the min sum to arrive this idx
        for (int i = 0; i< row; i++) {
            for (int j = 0; j< col; j++) {
                dp[i][j] = 201;
            }
        }

        dp[0][0] = grid[0][0];

        // fill the first row
        for (int j = 1; j < col ; j++) {
            dp[0][j] = grid[0][j] + dp[0][j-1];
        }

        // fill the first cols
        for (int i = 1; i < row; i++) {
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[row-1][col-1];


    }
}
