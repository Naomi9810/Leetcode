/**
 * Created by Sijia on 2/17/22
 * Time Complexity:
 * <p> NlogN + N
 * Space Complexity:
 * <p>
 * Hints: 跟calendar 3 一个题目
 * 全部打散， start 排序 end 排序 然后扫一边 一旦出现了 end在start之前的情况 room++
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.sortInterval;

import java.util.Arrays;

public class LC_0253_MeetingRoom_II {
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int j = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[j])
                rooms++;
            else
                j++;
        }
        return rooms;
    }
}
