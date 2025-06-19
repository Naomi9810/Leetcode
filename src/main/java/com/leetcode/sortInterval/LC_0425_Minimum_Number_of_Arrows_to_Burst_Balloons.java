/**
 * Created by Sijia on 2/7/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.sortInterval;

import java.util.Arrays;
import java.util.Comparator;

public class LC_0425_Minimum_Number_of_Arrows_to_Burst_Balloons {
    public int findMinArrowShots(int[][] points) {
        // corner
        if (points.length == 1) return 1;

        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        // sort by start

        int[] pre = points[0];
        int res = 1; // initial arrow for pre
        for (int i = 1; i < points.length; i++) {
            // can merge
            int[] cur = points[i];
            if (pre[1] >= cur[0]) {
                pre[1] = Math.min(pre[1], cur[1]);
            } else {
                res++;
                pre = cur;
            }
        }
        return res;
    }
}
