/**
 * Created by Sijia on 12/12/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: dp[i][j] the min edit distance convert from word1 to word2, first i char to first j
 * <p> 1. if char i == char j  then dp[i][j] = dp[i-1][j-1]
 * <p> 2. if char i != char j  then dp[i][j] = Min( dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
 * insert in word2, insert in word1/ delete in word2, replace
 * base case: dp[0][k] = dp[k][0] = k //  all one word len is 0
 * <p> 3.
 */

package com.leetcode.dp;

public class LC_0074_Edit_Distance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dist = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 && j == 0) {
                    dist[i][j] = 0;
                } else if (i == 0 || j == 0) {
                    dist[i][j] = i == 0 ? j : i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dist[i][j] = dist[i - 1][j - 1];
                } else {
                    dist[i][j] = Math.min(dist[i - 1][j - 1], Math.min(dist[i - 1][j], dist[i][j - 1])) + 1;
                }
            }
        }
        return dist[len1][len2];
    }
}
