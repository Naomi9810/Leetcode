/**
 * Created by Sijia on 12/18/21
 * Time Complexity:
 * <p>Time: O(M+N)
 * Space: O(N)
 * M: the length of input array
 * N: the range of the value of each int element
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. for numbers from [1 - 10000], each has a total sum sums[i]; if you earn sums[i], you cannot earn sums[i-1]
 * and sums[i+1] kind of like house robbing. you cannot rob 2 connected houses.
 * <p> 2.
 * take[i] = skip[i-1] + values[i];
 * skip[i] = Math.max(skip[i-1], take[i-1]);
 * take[i] can only be derived from: if you skipped the [i-1]th bucket, and you take bucket[i].
 * skip[i] through, can be derived from either take[i-1] or skip[i-1], whatever the bigger;
 * <p> 3.
 */

package com.goo.dp;

public class LC_0740_Delete_and_Earn {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for (int n : nums) {
            count[n] += n;
        }
        int[] dp = new int[10001];
        dp[0] = count[0];
        dp[1] = count[1];
        for (int i = 2; i < 10001; i++) {
            dp[i] = Math.max(count[i] + dp[i-2], dp[i-1]);
        }
        return dp[10000];
    }
}
