/**
 * Created by Sijia on 3/3/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.graph;

import java.util.*;

public class LC_0261_Graph_Valid_Tree {
    public boolean validTree(int n, int[][] edges) {
    Map<Integer, Set<Integer>> graph = new HashMap<Integer,Set<Integer>>();
    buildGraph(edges, graph);

    Set<Integer> set = new HashSet<>(); // visited

    // only visit once
    Queue<Integer> que = new ArrayDeque<>();
    boolean[] visited = new boolean[n];
        que.offer(0);
    visited[0] = true;

        while (!que.isEmpty()) {
        int cur = que.poll();
        n--;
        if (graph.containsKey(cur)) {
            for(int nei: graph.get(cur)){
                if (visited[nei]) return false;
                visited[nei] = true;
                que.offer(nei);
                graph.get(nei).remove(cur);
            }
        }
    }
        return n == 0;
}

    public void buildGraph(int[][] edges, Map<Integer, Set<Integer>> map) {
        for (int[] edge: edges) {
            int p1 = edge[0];
            int p2 = edge[1];
            map.putIfAbsent(p1, new HashSet<Integer>());
            map.get(p1).add(p2);
            map.putIfAbsent(p2, new HashSet<Integer>());
            map.get(p2).add(p1);
        }
    }
}
