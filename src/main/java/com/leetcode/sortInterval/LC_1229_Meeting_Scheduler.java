/**
 * Created by Sijia on 2/16/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Steps
 *  两种方法
 *  1. Sort by start + 2 Pointer
 *  2. Sort by start + priority queue
 */

package com.leetcode.sortInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC_1229_Meeting_Scheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0])); // priority queue

        for (int[] s : slots1) {
            if (s[1] - s[0] >= duration) pq.add(s); // only add the > duration intervals
        }
        for (int[] s : slots2) {
            if (s[1] - s[0] >= duration) pq.add(s);
        }

        while (pq.size() > 1) {
            int[] first = pq.remove();
            int[] second = pq.peek();

            if (duration <= first[1] - second[0])
                return Arrays.asList(second[0], second[0] + duration);
        }

        return new ArrayList<>();

    }
}
