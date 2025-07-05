/**
 * Created by Sijia on 2/25/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.topologicalSort;

import java.util.*;

public class LC_0207_Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] pair : prerequisites) {
            graph.putIfAbsent(pair[1], new ArrayList<>());
            graph.get(pair[1]).add(pair[0]);
        }

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, graph, visiting, visited)) return false;
        }

        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> graph, Set<Integer> visiting, Set<Integer> visited) {
        if (visited.contains(course)) return true;
        if (visiting.contains(course)) return false; // cycle found

        visiting.add(course);

        for (int neighbor : graph.getOrDefault(course, new ArrayList<>())) {
            if (!dfs(neighbor, graph, visiting, visited)) return false;
        }

        visiting.remove(course);
        visited.add(course);
        return true;
    }
}
