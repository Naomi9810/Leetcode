/**
 * Created by Sijia on 2/14/22
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

public class LC_1761_Minimum_Degree_of_a_Connected_Trio_in_a_Graph {
    public int minTrioDegree(int n, int[][] edges) {
        boolean[][] graph = new boolean[n + 1][n + 1];
        int[] degree = new int[n + 1];
        int res = Integer.MAX_VALUE;

        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (graph[i][j]) {
                    for (int k = j + 1; k <= n; k++) {
                        if (graph[i][k] && graph[j][k]) {
                            res = Math.min(res, degree[i] + degree[j] + degree[k] - 6);
                        }
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
