/**
 * Created by Sijia on 12/14/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. return true if first person wins
 * <p> 2. two options: take i or len-1,
 * <p> 3. dp[i][j] means the biggest number of stones you can get more than opponent picking piles in piles[i] ~ piles[j].
 * You can first pick piles[i] or piles[j]: https://leetcode.com/problems/stone-game/discuss/154610/DP-or-Just-return-true
 * use i and j because we need to keep track of the tail
 */

package com.leetcode.dp;

public class LC_0877_Stone_Game_I {
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = piles[i];
        }
        // pick left, then you get piles[i] - dp[i+1][j]  Alice get - Bob get = what Alice finally get from i to j
        // pick right, then you get piles[j] - dp[i][j-1]
        for (int i = 0; i + 1 < len; i++) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] > 0;

    }
}
