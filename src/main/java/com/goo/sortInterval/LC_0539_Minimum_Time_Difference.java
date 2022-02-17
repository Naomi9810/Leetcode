/**
 * Created by Sijia on 2/10/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.sortInterval;

import java.util.Arrays;
import java.util.List;

public class LC_0539_Minimum_Time_Difference {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] points = new int[n];

        for (int i = 0; i < n; i++) {
            int converted = convert(timePoints.get(i));
            points[i] = converted;
        }

        Arrays.sort(points);
        int res = Integer.MAX_VALUE;
        int pre = points[0];

        for (int i = 1; i < n; i++) {
            res = Math.min(res, points[i] - pre);
            pre = points[i];
        }

        // edge case of 23:59 and 00:00
        int corner = 60 * 24 + points[0] - points[n - 1];

        return Math.min(corner, res);

    }

    private int convert(String time) {
        String[] divided = time.split(":");
        int hour = Integer.parseInt(divided[0]);
        int m = Integer.parseInt(divided[1]);
        return hour * 60 + m;
    }
}
