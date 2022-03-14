/**
 * Created by Sijia on 3/12/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_1091_Shortest_Path_in_Binary_Matrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;

        int m = grid.length, n = grid[0].length;
        Deque<int[]> que = new ArrayDeque<>();
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;
        que.offer(new int[]{0, 0});
        grid[0][0] = 1;
        int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {1, 1}, {1, -1}, {1, 0}, {0, -1}, {0, 1}};

        int step = 1;
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                int[] cur = que.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1) {
                    return step;
                }
                for (int[] d : dir) {
                    int i2 = d[0] + cur[0];
                    int j2 = d[1] + cur[1];
                    if (i2 < 0 || j2 < 0 || i2 >= grid.length || j2 >= grid[0].length || grid[i2][j2] == 1) continue;
                    if (i2 == m - 1 && j2 == n - 1) {
                        return step + 1;
                    }
                    que.offer(new int[]{i2, j2});
                    grid[i2][j2] = 1;
                }
            }
            step++;
        }
        return -1;
    }
}
