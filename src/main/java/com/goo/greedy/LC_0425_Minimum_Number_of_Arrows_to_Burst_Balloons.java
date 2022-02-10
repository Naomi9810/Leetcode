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

package com.goo.greedy;

import java.util.Arrays;

public class LC_0425_Minimum_Number_of_Arrows_to_Burst_Balloons {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) return 0; // invalid input

        Arrays.sort(points, (o1, o2) -> {
            if (o1[1] == o2[1]) return 0;
            if (o1[1] < o2[1]) return -1;
            return 1;
        });

        int shot = 1;
        int preRight = points[0][1];

        for (int i = 1; i< points.length; i++) {
            int left = points[i][0];
            int right = points[i][1];

            if (left > preRight) {
                shot ++;
                preRight = right;
            } else {
                continue;
            }
        }
        return shot;
    }
}
