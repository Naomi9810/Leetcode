/**
 * Created by Sijia on 3/13/22
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

import java.util.HashMap;
import java.util.Map;

public class LC_0447_Number_of_Boomerangs {
    public int numberOfBoomerangs(int[][] points) {
        // find a point where two other points has same dist;
        if (points == null || points.length < 3) return 0;
        int res = 0;
        Map<Integer, Integer> distMap = new HashMap<>(); //dist, count
        for (int i = 0; i < points.length; i++) {
            for (int j = 0 ; j < points.length; j++) {
                if (i == j) continue;
                int[] p1 = points[i];
                int[] p2 = points[j];
                int dist = getDist(p1, p2);
                distMap.put(dist, distMap.getOrDefault(dist, 0) +1);
            }
            for (Integer count: distMap.values()) {
                res += count * (count - 1); // 每两个来算
            }
            distMap.clear();
        }
        return res;
    }

    private int getDist(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
