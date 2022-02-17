/**
 * Created by Sijia on 2/3/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. Use priorityQueue to calculate the rank
 * 1. need to be available cur time >= enqueue time
 * 2. Prioritize the processing time -> choose the min
 * same -> choose small idx
 *
 https://leetcode.com/problems/single-threaded-cpu/discuss/1164102/Java%3A-sort-by-time-and-use-PQ
 * <p> 2.   前提条件是 start time 用start time 排序
 *          优先级是 processing time 用 processing time 作为minHeap的comparator
 *          然后用while 循环 进行simulation
 * <p> 3.
 */

package com.goo.sortInterval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC_1834_Single_Threaded_CPU {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length; // number of tasks
        int[][] sortedTask = new int[n][3];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            sortedTask[i][0] = i; // idx
            sortedTask[i][1] = tasks[i][0]; // start time
            sortedTask[i][2] = tasks[i][1]; // process time
        }
        Arrays.sort(sortedTask, (a, b) -> Integer.compare(a[1], b[1])); // sort by start time
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] == b[2] ? Integer.compare(a[0], b[0]) : Integer.compare(a[2], b[2]));
        // only put available task in the minHeap, compare process time first, then compare index

        int time = 0; // 最早可以开始的时间
        int i = 0, ti = 0; // i is order idx, ti is task idx
        while (i < n) {
            while (ti < n && sortedTask[ti][1] <= time) {
                minHeap.offer(sortedTask[ti++]);
            }
            if (!minHeap.isEmpty()) {
                int[] next = minHeap.poll();
                res[i++] = next[0];
                time += next[2];
            } else {
                // need to wait until the next available task to come
                time = sortedTask[ti][1];
            }
        }
        return res;
    }
}
