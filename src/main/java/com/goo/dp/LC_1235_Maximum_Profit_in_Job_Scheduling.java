/**
 * Created by Sijia on 2/14/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: 对于每一个i 有三种选择
 * 1. 不选后面的dp[i] = dp[i-1]
 * 2. 另起炉灶 dp[i] = profit[i]
 * 3. 两个都要 前提是后一个task的start 要小于等于前一个task的 end dp[i] = dp[j] + profit[i]
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.dp;

import java.util.Arrays;

public class LC_1235_Maximum_Profit_in_Job_Scheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            // 0: start ,  1: end , 2: profit
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));

        int dp[] = new int[n]; // dp means the max profit if we select from 0 to i
        dp[0] = jobs[0][2];

        for (int i = 1; i < n; i++) {
            // skip i or choose i
            dp[i] = Math.max(dp[i - 1], jobs[i][2]);
            for (int j = i - 1; j >= 0; j--) {
                if (jobs[j][1] <= jobs[i][0]) {
                    // can start
                    // find the largest value we can have if we choose i
                    dp[i] = Math.max(dp[i], dp[j] + jobs[i][2]);
                    break;
                }
            }
        }
        return dp[n-1];
    }
}
