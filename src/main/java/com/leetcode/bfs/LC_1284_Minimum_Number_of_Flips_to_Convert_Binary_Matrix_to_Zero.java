/**
 * Created by Sijia on 2/2/22
 * https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/discuss/446342/JavaPython-3-Convert-matrix-to-int%3A-BFS-and-DFS-codes-w-explanation-comments-and-analysis.
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: 用int 代替整个 matrix的状态
 * <p> 1. 遇见1 的位置 拉直成n
 * <p> 2. 向左移动n个位置 然后取 OR
 * <p> 3.
 */

package com.leetcode.bfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class LC_1284_Minimum_Number_of_Flips_to_Convert_Binary_Matrix_to_Zero {

    public int minFlips(int[][] mat) {
        int row = mat.length;
        if (row == 0) return 0;
        int col = mat[0].length;

        Set<Integer> visited = new HashSet<>();
        int start = getMask(mat, row, col);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited.add(start);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                if (cur == 0) {
                    return step;
                }
                for (int i = 0; i < row * col; i++) {
                    int next = flip(cur, i, row, col);
                    if (visited.add(next)) {
                        queue.add(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }


    private int getMask(int[][] mat, int row, int col) {
        int res = 0;

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    int n = i * mat[0].length + j;
                    res |= 1 << n;
                }
            }
        }
        return res;
    }

    private int flip(int cur, int pos, int row, int col) {
        // flip the pos one
        cur ^= 1 << pos; // flip this position, 取反
        // flip the 4 dir
        int x = pos / col, y = pos % col;
        int[][] dir = new int[][]{{0, -1}, {1, 0}, {-1, 0}, {0, 1}};
        for (int[] d: dir) {
            int x2 = x + d[0];
            int y2 = y + d[1];
            if (x2 < 0 || y2 < 0 || x2 >= row || y2 >= col) continue;
            int next = x2 * col + y2;
            cur ^= 1 << next;
        }
        return cur;
    }
}
