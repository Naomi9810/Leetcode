/**
 * Created by Sijia on 12/25/21
 * Time Complexity:
 * <p> O(N^2) sliding window
 * Space Complexity:
 * <p> O(N) N is the # of points
 * Hints:
 * <p> 1. The atan2() method returns a numeric value [-pi, pi]  representing the angle \theta  of a (x, y) point and the positive x-axis.
 * <p> 2. The java.lang.Math.toDegrees() is used to convert an angle measured in radians to an approximately equivalent angle measured in degrees.
 * <p> 3.
 */

package com.goo.twoPointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC_1610_Maximum_Number_of_Visible_Points {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int same = 0;
        int x = location.get(0), y = location.get(1);
        for (List<Integer> point : points) {
            int dx = point.get(0) - x;
            int dy = point.get(1) - y;
            if (dx == 0 && dy == 0) {
                same++; //  corner case:
                continue;
            }
            angles.add(Math.toDegrees(Math.atan2(dy, dx))); //
        }
        Collections.sort(angles);
        // need to deal the negative value:
        List<Double> sorted = new ArrayList<>(angles);
        for (double a : angles) {
           sorted.add(a + 360);
        }
        int res = 0;
        for (int left = 0, right = 0; right < sorted.size(); right++) {
            while (sorted.get(right) - sorted.get(left) > angle) {
                left++;
            } // what between left and right will be <= angle  sliding window
            res = Math.max(res, right - left + 1);
        }
        return res + same;
    }
}
