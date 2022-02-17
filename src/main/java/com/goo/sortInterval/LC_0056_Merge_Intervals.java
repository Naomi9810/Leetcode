/**
 * Created by Sijia on 2/14/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: 用一个pre 即可
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.sortInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_0056_Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, ((a, b) -> (Integer.compare(a[0], b[0]))));
        List<int[]> res =  new ArrayList<>();

        int[] pre = intervals[0];
        res.add (pre);
        for (int[] cur: intervals) {
            if (cur[0] > pre[1]) {
                pre = cur;
                res.add(cur);
            } else {
                // need to merge
                pre[1] = Math.max(pre[1], cur[1]);

            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
