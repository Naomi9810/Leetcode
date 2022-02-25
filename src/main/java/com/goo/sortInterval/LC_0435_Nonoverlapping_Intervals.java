/**
 * Created by Sijia on 2/24/22
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

public class LC_0435_Nonoverlapping_Intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> (Integer.compare(a[1], b[1]))); // sort by end
        int end = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++; //  可以衔接的
            }
        }

        return intervals.length - count; // 反向操作

        // sort by start
        // 当前一个和后一个冲突 总是选择 end早些结束的
//     int end = intervals[0][1], prev = 0, count = 0;
//     for (int i = 1; i < intervals.length; i++) {
//       if (intervals[prev][1] > intervals[i][0]) {
//         if (intervals[prev][1] > intervals[i][1]) {
//           prev = i;
//         }
//         count++;
//       } else {
//         prev = i;
//       }
//     }
//     return count;

    }
}
