/**
 * Created by Sijia on 1/1/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. search in the grid and find the '*' as start point
 * <p> 2. use BFS to search the shortest path, if food is found, return the path
 * <p> 3. if not found return -1
 */

package com.goo.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC_1730_Shortest_Path_to_Get_Food {
    public int getFood(char[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[] start = findStart(grid, row, col);
        int i = start[0], j = start[1];

        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        visited[i][j] = true;
        que.offer(new int[]{i, j, 0});

        // BFS:
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int[] d : dir) {
                int i2 = cur[0] + d[0];
                int j2 = cur[1] + d[1];
                int dist = cur[2];
                if (i2 < 0 || j2 < 0 || i2 >= row || j2 >= col || grid[i2][j2] == 'X' || visited[i2][j2]) continue;
                if (grid[i2][j2] == '#') return dist + 1; // find the food;
                // not visited free space 'O' case
                visited[i2][j2] = true;
                que.offer(new int[]{i2, j2, dist + 1});
            }
        }
        return -1;
    }

    private int[] findStart(char[][] grid, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '*') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};

    }
}
