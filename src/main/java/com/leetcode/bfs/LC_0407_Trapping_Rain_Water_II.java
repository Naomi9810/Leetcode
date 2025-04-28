/**
 * Created by Sijia on 12/29/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. 四周的加进priorityqueue
 * <p> 2. 基本bfs 四个方向visit
 * <p> 3.
 */

package com.leetcode.bfs;

import java.util.PriorityQueue;

public class LC_0407_Trapping_Rain_Water_II {
    public int trapRainWater(int[][] heightMap) {
        int row = heightMap.length;
        int col = row == 0 ? 0 : heightMap[0].length;
        int water = 0;

        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[2] - b[2]); //  i, j, height sort by height
        boolean[][] visited = new boolean[row][col];

        // added the border, left, right two col
        for (int i = 0; i < row; i++) {
            que.offer(new int[]{i, 0, heightMap[i][0]});
            que.offer(new int[]{i, col - 1, heightMap[i][col - 1]});
            visited[i][0] = visited[i][col - 1] = true;
        }
        // top and bottom row
        for (int j = 1; j < col; j++) {
            que.offer(new int[]{0, j, heightMap[0][j]});
            que.offer(new int[]{row - 1, j, heightMap[row - 1][j]});
            visited[0][j] = visited[row - 1][j] = true;
        }

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int[] d : dirs) {
                int i2 = cur[0] + d[0];
                int j2 = cur[1] + d[1];
                if (i2 < 0 || j2 < 0 || i2 >= row || j2 >= col || visited[i2][j2]) continue;
                water += Math.max(0, cur[2] - heightMap[i2][j2]); // 从border向内visit， 一旦发现小于cur height 就可以算water
                que.offer(new int[]{i2, j2, Math.max(cur[2], heightMap[i2][j2])}); // 一定要放更高的作为边界放进去
                visited[i2][j2] = true;
            }
        }
        return water;
    }
}
