/**
 * Created by Sijia on 2/23/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.substringAndString;

public class LC_647_Palindromic_Substrings {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        boolean[][] dp = new boolean[s.length()][s.length()];// dp[i][j] from idx i - j. is a valid pali
        // base case:
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            count++;
        }

        // len == 2
        for (int i = 1; i < s.length(); i++) {
            dp[i-1][i] = s.charAt(i-1) == s.charAt(i);
            if (dp[i-1][i]) {
                count++;
            }
        }

        // len >= 3
        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0, j = i + len - 1; j < s.length(); i++, j++) {
                dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count++;
    }
}
