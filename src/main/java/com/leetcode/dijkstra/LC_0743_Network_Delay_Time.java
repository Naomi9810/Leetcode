/**
 * Created by Sijia on 2/13/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.dijkstra;

import java.util.*;

public class LC_0743_Network_Delay_Time {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>(); //. start:(end:cost)
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        if (!map.containsKey(k)) {
            return -1; // doesn't include the start;
        }
        Set<Integer> visited = new HashSet<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1])); // only find the nearest
        minHeap.offer(new int[]{k, 0});
        int res = 0;


        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int curNode = cur[0];
            int curCost = cur[1];
            if (visited.contains(curNode)) continue;
            visited.add(curNode);
            res = curCost;
            if (visited.size() == n) return res;

            if (map.containsKey(curNode)) {
                Map<Integer, Integer> costMap = map.get(curNode);
                for (int next : costMap.keySet()) {
                    minHeap.add(new int[]{next, curCost + costMap.get(next)});
                }
            }
        }
        return visited.size() == n ? res : -1;
    }

}
