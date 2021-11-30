package com.goo.dp;

/**
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: when this is 1.
 * <p> 1. dp[i][j] = Math.max (dp[i-1][j] + 1 + dp[i+1][j], )
 * <p> 2.
 * <p> 3.
 */
public class LC_0562_Longest_Line_of_Consecutive_One_in_Matrix {
  public int longestLine(int[][] mat) {
    if (mat == null || mat.length == 0 || mat[0].length == 0) return 0;
    int res = 0;
    int[][] dp = new int[mat[0].length][4];
    


  }


}
