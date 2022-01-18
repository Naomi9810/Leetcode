/**
 * Created by Sijia on 1/14/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: https://leetcode.com/problems/maximum-number-of-points-with-cost/discuss/1344908/C%2B%2BJavaPython-3-DP-Explanation-with-pictures.
 * <p> 1. 左右都要算一遍 不能遗漏， 要么竖着直接取 pre[j] 或者 向左 向右
 * <p> 2.
 * <p> 3.
 */

package com.goo.greedy;

public class LC_1937_Maximum_Number_of_Points_with_Cost {
    public long maxPoints(int[][] points) {
        long res = 0;
        int row = points.length, col = points[0].length;
        long[] pre = new long[col];
        for (int j = 0; j < col; j++) {
            pre[j] = points[0][j];
        }
        for (int i = 1; i < row; i++) {
            long[] cur = new long[col], left = new long[col], right = new long[col];
            left[0] = pre[0];
            right[col - 1] = pre[col - 1];
            for (int j = 1; j < col; j++) {
                left[j] = Math.max(pre[j], left[j - 1] - 1);
            }
            for (int j = col - 2; j >= 0; j--) {
                right[j] = Math.max(pre[j], right[j + 1] - 1);
            }
            for (int j = 0; j < col; j++) {
                cur[j] = points[i][j] + Math.max(left[j], right[j]);
                pre = cur;
            }
        }

        for (int j = 0; j < col; j++) {
            res = Math.max(res, pre[j]);
        }
        return res;
    }
}
