package com.leetcode.dp;

import java.util.List;

public class LC_0120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        // idx, choose from idx and idx+1
        int rows = triangle.size();
        int cols = triangle.get(rows - 1).size();

        int[] dp = new int[rows];

        for (int i = 0; i < cols; i++) {
            dp[i] = triangle.get(cols - 1).get(i);
        }

        // Bottom-up DP. climb up
        for (int i = cols - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                int num = row.get(j);
                dp[j] = num + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0]; // only this one gets to the top [0][0]

    }
}
