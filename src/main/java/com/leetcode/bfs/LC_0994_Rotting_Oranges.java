/**
 * Created by Sijia on 3/28/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_0994_Rotting_Oranges {
    public int orangesRotting(int[][] grid) {
        int good = 0, time = 0;
        Deque<int[]> que = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    que.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    good++;
                }
            }
        }

        if (good == 0) return 0; // no good at all
        if (que.isEmpty()) return -1; // can't spread

        int[][] dir = new int[][] {{1,0},{-1, 0},{0, 1}, {0, -1}};

        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                int[] cur = que.poll();
                for (int[] d: dir) {
                    int i2 = cur[0] + d[0];
                    int j2 = cur[1] + d[1];
                    if (i2 < 0 || j2 < 0 || i2 >= grid.length || j2 >= grid[0].length) continue;
                    if (grid[i2][j2] != 1) continue; // empty or visited
                    good--;
                    grid[i2][j2] = 2;
                    que.offer(new int[] {i2, j2});
                }
            }
            time++;
            if (good == 0) return time;
        }
        return -1;

    }
}
