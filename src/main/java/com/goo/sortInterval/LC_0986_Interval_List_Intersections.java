/**
 * Created by Sijia on 3/8/22
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

import java.util.ArrayList;
import java.util.List;

public class LC_0986_Interval_List_Intersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {
            int[] i1 = firstList[i];
            int[] i2 = secondList[j];

            int start = Math.max(i1[0], i2[0]);
            int end = Math.min(i1[1], i2[1]);
            // 找到

            if (start <= end) {
                res.add(new int[] {start, end});
            }

            if (i1[1] < i2[1]) {
                i++;
            } else {
                j++;
            }
        }

        return res.toArray(new int[0][]);
    }

}
