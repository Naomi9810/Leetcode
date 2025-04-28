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


        int[] degree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] course : prerequisites) {
            int pre = course[1];
            int cur = course[0];
            degree[cur]++;
            map.putIfAbsent(pre, new ArrayList<>());
            map.get(pre).add(cur);
        }

        Queue<Integer> que = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                que.offer(i);
            }
        }

        if (que.isEmpty()) return false;

        int count = 0;

        while (!que.isEmpty()) {
            int cur = que.poll();
            count++;
            List<Integer> courseList = map.get(cur);
            map.remove(cur);// remove the visited
            if (courseList != null) {
                for (int next : courseList) {
                    degree[next]--;
                    if (degree[next] == 0) {
                        que.offer(next);
                    }
                }
            }
        }
        return count == numCourses;

    }
}
