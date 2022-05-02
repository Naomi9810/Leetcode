/**
 * Created by Sijia on 2/15/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.mathBitMatrix;

public class LC_1779_Find_Nearest_Point_Has_the_Same_XORY {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDist = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i <  points.length; i++) {
            int dx = points[i][0] - x;
            int dy = points[i][1] - y;
            int dist = Math.abs(dx) + Math.abs(dy);
            if (dx * dy == 0 && dist < minDist) {
               minDist = dist;
               res = i;
            }
        }
        return res;
    }
}
