/**
 * Created by Sijia on 2/28/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.twoPointer;

import java.util.ArrayList;
import java.util.List;

public class LC_0057_insert_interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) return new int[][] {newInterval};
        if (newInterval == null || newInterval.length == 0) return intervals;

        List<int[]> res = new ArrayList<>();
        // add all before newInterval
        int i = 0;
        int start = newInterval[0], end = newInterval[1]; // two variable as new interval start

        while (i < intervals.length && intervals[i][1] < start) {
            res.add(intervals[i++]);
        }

        while (i < intervals.length && intervals[i][0] <= end) {
            //merge
            start = Math.min(intervals[i][0], start);
            end = Math.max(intervals[i][1], end);
            i++;
        }
        res.add(new int[] {start, end});

        while (i < intervals.length) {
            res.add(intervals[i++]);
        }

        return res.toArray(new int[res.size()][]);
    }
}
