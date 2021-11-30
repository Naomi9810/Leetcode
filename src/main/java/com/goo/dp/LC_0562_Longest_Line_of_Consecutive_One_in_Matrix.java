package com.goo.dp;

/**
 * Time Complexity:
 * <p> O(M*N) M is row, N is col
 * Space Complexity:
 * <p> O(M*N) M is row, N is col
 * Hints: when this is 1.
 * <p> 1. https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/discuss/102266/Java-O(nm)-Time-DP-Solution
 * <p> 2.
 * <p> 3.
 */
public class LC_0562_Longest_Line_of_Consecutive_One_in_Matrix {
    public int longestLine(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) return 0;
        int res = 0;
        int row = mat.length, col = mat[0].length;
        int[][][] dp = new int[row + 2][col + 2][4]; // horizontal, vertical and diagonal
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    res = Math.max(res, dp[i + 1][j + 1][0] = dp[i][j + 1][0] + 1); // row
                    res = Math.max(res, dp[i + 1][j + 1][1] = dp[i + 1][j][1] + 1); // col
                    res = Math.max(res, dp[i + 1][j + 1][2] = dp[i][j][2] + 1); // diagonal
                    res = Math.max(res, dp[i + 1][j + 1][3] = dp[i][j + 2][3] + 1); // anti-diagonal
                }
            }
        }
        return res;
    }
}
