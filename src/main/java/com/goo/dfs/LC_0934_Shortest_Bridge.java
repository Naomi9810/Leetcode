/**
 * Created by Sijia on 3/10/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.dfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC_0934_Shortest_Bridge {
    /*
    Assumption : two island

    Solution:
    1. use dfs to find two island
    2. use bfs to connect two island
    3. shortest bridge == shortest distance

    Big O:


    */

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> que = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (que.isEmpty() && grid[i][j] == 1) {
                    // island
                    dfs(grid, i, j, que);
                    break;
                }
            }
        }

        int step = 0;
        int res = Integer.MAX_VALUE;
        int[][] dir = new int[] [] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                int[] cur = que.poll();
                for (int [] d: dir) {
                    int i2 = cur[0] + d[0];
                    int j2 = cur[1] + d[1];
                    if (i2 < 0 || j2 < 0 || i2 >= n || j2 >= n || grid[i2][j2] == -1) continue;
                    if (grid[i2][j2] == 1) {
                        return step;
                    }
                    grid[i2][j2] = -1;
                    que.offer(new int[] {i2, j2});
                }
            }
            step++;
        }
        return -1;
    }

    private void dfs(int[][] grid, int i, int j, Queue<int[]> island) {
        // base case:
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) return;

        // mark visited
        grid[i][j] = -1;
        island.add(new int[] {i, j});

        // 4 directions
        dfs(grid, i+1, j, island);
        dfs(grid, i-1, j, island);
        dfs(grid, i, j+1, island);
        dfs(grid, i, j-1, island);
    }
}
