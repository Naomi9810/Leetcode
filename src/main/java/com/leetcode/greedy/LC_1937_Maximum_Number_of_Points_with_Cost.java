/**
 * Created by Sijia on 1/14/22
 * Time Complexity: O(mn)
 * Space Complexity: O(n)
 * Hints: https://leetcode.com/problems/maximum-number-of-points-with-cost/discuss/1344908/C%2B%2BJavaPython-3-DP-Explanation-with-pictures.
 * <p> 1. 左右都要算一遍 不能遗漏， 要么竖着直接取 pre[j] 或者 向左 向右
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.greedy;

public class LC_1937_Maximum_Number_of_Points_with_Cost {
    // 新建col的 dp 初始值就是这行的 point[i][j]
    // 从左到右取大 从又到左取大 保证这行的max都取到
    public long maxPoints(int[][] points) {
        int rows = points.length;
        int cols = points[0].length;

        long[] dp = new long[cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                dp[j] += points[i][j];
            }

            //left to right pass
            for (int j = 1; j < cols; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1] - 1); // 取这一排的这个值 或者往左一排的值
            }

            //right to left pass
            for (int j = cols - 2; j >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j + 1] - 1);  // 取这一排的这个值 或者往往右一排的值
            }
        }

        long maxPoints = 0;
        for (int j = 0; j < cols; j++) {
            maxPoints = Math.max(maxPoints, dp[j]);
        }
        return maxPoints;
    }
}
