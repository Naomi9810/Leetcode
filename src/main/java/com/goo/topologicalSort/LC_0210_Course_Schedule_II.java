package com.goo.topologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Time Complexity: O(V+E) V number of vertices,  E number of Edges
 * <p>
 * Space Complexity: O(V+E) V number of vertices,  E number of Edges
 * <p>
 * Hints:
 * <p> 1. Topological sort, build the degree based from course number
 * <p> 2. Use queue to start poll from degree == 0
 * <p> 3.
 */
public class LC_0210_Course_Schedule_II {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] res = new int[numCourses];

    if (numCourses == 0) {
      return res;
    }

    HashMap<Integer, List<Integer>> courseMap = new HashMap<>();
    // course A, the course you can take after finish course A

    for (int i = 0; i < numCourses; i++) {
      courseMap.putIfAbsent(i, new ArrayList<>());
    }

    int[] degree = new int[numCourses];
    boolean[] visited = new boolean[numCourses];

    for (int[] pre : prerequisites) {
      courseMap.get(pre[1]).add(pre[0]);
      // eg: prerequisites = [[3,1]] to 1 -> 3
      degree[pre[0]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (degree[i] == 0) {
        queue.offer(i);
      }
    }

    if (queue.isEmpty()) { // there is circle
      return new int[0];
    }

    int count = 0;
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      visited[cur] = true;
      res[count++] = cur;
      for (int next : courseMap.get(cur)) {
        if (visited[next]) {
          continue;
        }
        degree[next]--;
        if (degree[next] == 0) {
          queue.offer(next);
        }
      }
    }

    if (count == numCourses) {
      return res; // able to finish all course
    } else {
      return new int[0];
    }
  }
}
