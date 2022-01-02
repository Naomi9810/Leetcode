/**
 * Created by Sijia on 12/31/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. greedy BFS try to go right and down possible to find a path, if we need the obstacles:
 * <p> 2. To find the shortest path in the unweighted-graph, we can use BFS
 * In this problem is a variant of BFS. Beside (r, c) we need to add 1 more param k,
 * which is the number of obstacles we can eliminate when we start at cell (r, c).
 * <p> 3. shortest way is m+n steps, we want to explore the right/down direction because we know the destination
 * A start algorithm： we cannot exclude (or prune) those less promising directions, otherwise we might miss the
 * correct path because sometimes we have to take a detour in order to reach the destination.
 * f(n) = g(n) + h(n)
 * total steps = steps traveled so far +  heuristic estimation this spot to destination
 */

package com.goo.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC_1293_ShortestPath_in_a_Grid_with_Obstacles_Elimination {
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestPath(int[][] grid, int k) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int row = grid.length;
        int col = grid[0].length;
        if (k >= row + col - 2) return row + col - 2; //  manhattan distance the shortest path.

        boolean[][][] visited = new boolean[row][col][k + 1];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0, k, 0}); // i, j, k, dist
        visited[0][0][k] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int i = cur[0], j = cur[1], curK = cur[2], dist = cur[3];
            if (i == row - 1 && j == col - 1) return dist; // reach the destination
            for (int[] d : dir) {
                int i2 = i + d[0], j2 = j + d[1];
                if (i2 < 0 || j2 < 0 || i2 >= row || j2 >= col) continue; // out of bond
                int nextK = curK - grid[i2][j2]; // eliminate next cell, if cell == 1, k = k-1:
                if (nextK >= 0 && !visited[i2][j2][nextK]) {
                    visited[i2][j2][nextK] = true;
                    que.add(new int[]{i2, j2, nextK, dist + 1});
                }
            }
        }
        return -1;
    }
}
