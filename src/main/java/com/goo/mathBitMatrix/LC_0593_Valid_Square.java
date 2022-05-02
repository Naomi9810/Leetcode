/**
 * Created by Sijia on 1/11/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: calculate the distance, and we only have 直角边 and 斜边
 * https://leetcode.com/problems/valid-square/discuss/931888/Valid-Square-or-Java-or-simple-O(1)-solution
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.mathBitMatrix;

import java.util.HashSet;
import java.util.Set;

public class LC_0593_Valid_Square {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        set.add(getDist(p1, p2));
        set.add(getDist(p1, p3));
        set.add(getDist(p1, p4));
        set.add(getDist(p2, p3));
        set.add(getDist(p2, p4));
        set.add(getDist(p3, p4));

        return set.size() == 2 && !set.contains(0);
    }

    private int getDist(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
