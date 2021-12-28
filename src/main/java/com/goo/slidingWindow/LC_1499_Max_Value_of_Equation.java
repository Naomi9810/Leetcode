/**
 * Created by Sijia on 12/26/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. sorted by the x-values
 * <p> 2. yi + yj + |xi - xj| == yi + yj + xi - xj when xi > xj;
 * <p> 3.
 */

package com.goo.slidingWindow;

public class LC_1499_Max_Value_of_Equation {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int len = points.length;
        int max = points[0][1] + points[1][1] + Math.abs(points[0][0] - points[1][0]);
        for (int i = 0; i < len; i++) {
            for (int j = 1; j > i && j < len; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                int dx = Math.abs(xi - xj);
                if (dx <= k) {
                    max = Math.max(max, yi + yj + dx);
                }
            }
        }
        return max;
    }
}
