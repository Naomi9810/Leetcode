/**
 * Created by Sijia on 2/17/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: direct bfs will LTE, need to set both bus and stops visited.
 * 优化放在 comment里 建立busTobus 的map 找到有target 和 source 车子的bus 然后只用搜索bus即可
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.graph;

import java.util.*;

public class LC_0815_Bus_Routes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        Map<Integer, HashSet<Integer>> graph = new HashMap<>(); // stop:bus


        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                graph.putIfAbsent(stop, new HashSet<Integer>());
                graph.get(stop).add(i);
            }
        }

        Set<Integer> visitedStop = new HashSet<>();
        Set<Integer> visitedBus = new HashSet<>();

        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{source, 0}); //  0 is the #bus
        visitedStop.add(source);

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int stop = cur[0], bus = cur[1];
            if (stop == target) {
                return bus;
            }
            for (int i : graph.get(stop)) {
                if (visitedBus.contains(i)) continue;
                // get the connected bus
                for (int j : routes[i]) {
                    if (visitedStop.contains(j)) continue;
                    visitedStop.add(j);
                    que.offer(new int[]{j, bus + 1});
                }
                visitedBus.add(i);
            }
        }
        return -1;
    }

//    public int numBusesToDestination(int[][] routes, int source, int target) {
//        if (source==target) return 0;
//        int N = routes.length;
//
//        List<List<Integer>> graph = new ArrayList();
//        for (int i = 0; i < N; ++i) {
//            graph.add(new ArrayList());
//        }
//        Set<Integer> seen = new HashSet();
//        Set<Integer> targets = new HashSet();
//        Queue<Pair<Integer,Integer>> queue = new ArrayDeque();
//
//        // Build the graph.  Two buses are connected if
//        // they share at least one bus stop.
//        for (int i = 0; i < routes.length; ++i)
//            for (int j = i+1; j < routes.length; ++j)
//                if (intersect(routes[i], routes[j])) {
//                    graph.get(i).add(j);
//                    graph.get(j).add(i);
//                }
//
//        // Initialize seen, queue, targets.
//        // seen represents whether a node has ever been enqueued to queue.
//        // queue handles our breadth first search.
//        // targets is the set of goal states we have.
//        for (int i = 0; i < N; ++i) {
//            if (Arrays.binarySearch(routes[i], source) >= 0) {
//                seen.add(i);
//                queue.offer(new Pair<>(i, 0));
//            }
//            if (Arrays.binarySearch(routes[i], target) >= 0)
//                targets.add(i);
//        }
//
//        while (!queue.isEmpty()) {
//            Pair<Integer,Integer> info = queue.poll();
//            int node = info.getKey(), depth = info.getValue();
//            if (targets.contains(node)) return depth+1;
//            for (Integer nei: graph.get(node)) {
//                if (!seen.contains(nei)) {
//                    seen.add(nei);
//                    queue.offer(new Pair<>(nei, depth+1));
//                }
//            }
//        }
//
//        return -1;
//    }
//
//    public boolean intersect(int[] A, int[] B) {
//        int i = 0, j = 0;
//        while (i < A.length && j < B.length) {
//            if (A[i] == B[j]) return true;
//            if (A[i] < B[j]) i++; else j++;
//        }
//        return false;
//    }
}
