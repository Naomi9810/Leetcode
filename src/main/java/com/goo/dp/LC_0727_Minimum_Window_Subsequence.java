/**
 * Created by Sijia on 2/11/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: https://leetcode.com/problems/minimum-window-subsequence/discuss/109362/Java-Super-Easy-DP-Solution-(O(mn))
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.dp;

public class LC_0727_Minimum_Window_Subsequence {
    public String minWindow(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len2+1][len1+1]; //dp ij means the start idx substring in s2 and s1

        for (int j = 0; j <= len1; j++) {
            dp[0][j] = j+1;
        }

        for (int i = 1; i <= len2; i++) {
            for (int j = 1; j <=len1; j++) {
                if (s1.charAt(j-1) == s2.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        int start = 0, len = len1 + 1;

        for (int j = 1; j <= len1; j++) {
            if (dp[len2][j] != 0 && j - dp[len2][j] + 1 < len) {
                start = dp[len2][j] - 1;
                len = j - dp[len2][j] + 1;
            }
        }

        return len == len1+1? "":s1.substring(start, start+len);

    }
}
