/**
 * Created by Sijia on 1/18/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: shorted distance using bfs
 * https://leetcode.com/problems/01-matrix/discuss/1369741/C%2B%2BJavaPython-BFS-DP-solutions-with-Picture-Clean-and-Concise-O(1)-Space
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC_0542_01_Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        Queue<int[]> que = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    que.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1; // marked as not visited
                }
            }
        }

        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int i = cur[0], j = cur[1];
            for (int[] d : dir) {
                int i2 = i + d[0], j2 = j + d[1];
                if (i2 < 0 || j2 < 0 || i2 >= row || j2 >= col || mat[i2][j2] != -1) continue;
                mat[i2][j2] = mat[i][j] + 1;
                que.offer(new int[]{i2, j2});
            }
        }
        return mat;
    }
}
