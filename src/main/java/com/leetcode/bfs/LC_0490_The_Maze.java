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

package com.leetcode.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC_0490_The_Maze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) return false;
        if (maze[destination[0]][destination[1]] == 1) return false;
        Queue<int[]> que = new ArrayDeque<>();
        int row = maze.length, col = maze[0].length;
        boolean[][] visited = new boolean[row][col];

        que.offer(start);
        visited[start[0]][start[1]] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0], y = cur[1];

            if (destination[0] == x && destination[1] == y) return true;

            int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

            for (int[] d : dirs) {
                int x2 = x + d[0];
                int y2 = y + d[1];
                while (x2 >= 0 && y2 >= 0 && x2 < row && y2 < col && maze[x2][y2] == 0) { // 用while找到 停止的部分
                    x2 += d[0];
                    y2 += d[1];
                }
                // 减回去
                x2 -= d[0];
                y2 -= d[1];
                if (!visited[x2][y2]) {
                    que.offer(new int[]{x2, y2});
                    visited[x2][y2] = true;
                }
            }
        }
        return false;
    }
}
