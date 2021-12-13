package com.goo.dp;

import java.util.Arrays;

/**
 * Time Complexity:
 * <p> O(M*N) M is row, N is col
 * Space Complexity:
 * <p> O(M*N) M is row, N is col
 * Hints: when this is 1.
 * <p> 1. https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/discuss/102266/Java-O(nm)-Time-DP-Solution
 * <p> 2.  (i-1, j-1) (i-1, j) (i-1, j+1)
 * <p> 3.   (i, j-1)  (i, j)
 */
public class LC_0562_Longest_Line_of_Consecutive_One_in_Matrix {
    public int longestLine(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) return 0;
        int max = 0;
        int row = mat.length, col = mat[0].length;
        int[][][] dp = new int[row][col][4]; // horizontal, vertical, diagonal and anti-diagonal
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) continue;
                //  mat[i][j] == 1, at least length = 1 line in four directions, need to add here:
                for (int d = 0; d < 4; d++) {
                    dp[i][j][d] = 1;
                }
                if (j > 0) dp[i][j][0] += dp[i][j - 1][0]; // horizontal line
                if (i > 0) dp[i][j][1] += dp[i - 1][j][1]; // vertical line
                if (i > 0 && j > 0) dp[i][j][2] += dp[i - 1][j - 1][2]; // anti-diagonal line
                if (i > 0 && j + 1 < col) dp[i][j][3] += dp[i - 1][j + 1][3]; // diagonal line
                max = Math.max(max, Math.max(dp[i][j][0], dp[i][j][1]));
                max = Math.max(max, Math.max(dp[i][j][2], dp[i][j][3]));
            }
        }
        return max;
    }
}
