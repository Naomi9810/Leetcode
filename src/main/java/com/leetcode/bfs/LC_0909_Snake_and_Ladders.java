package com.leetcode.bfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class LC_0909_Snake_and_Ladders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> que = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        que.add(1);
        visited.add(1);
        int steps = 0;

        while (!que.isEmpty()) {
            int size = que.size(); // BFS 一层的数量
            for (int i = 0; i < size; i++) {
                int cur = que.remove();

                if (cur == n * n)
                    return steps;

                for (int move = 1; move <= 6 && cur + move <= n * n; move++) {
                    int next = cur + move;
                    int[] idx = num2Idx(next, n);
                    int val = board[idx[0]][idx[1]];
                    int dest = val == -1 ? next : val;

                    if (!visited.contains(dest)) {
                        visited.add(dest);
                        que.add(dest);
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    public int[] num2Idx(int val, int n) {
        int rowFromBottom = (val - 1) / n;
        int offset = (val - 1) % n;

        int row = n - 1 - rowFromBottom;
        int col = rowFromBottom % 2 == 0 ? offset : n - 1 - offset;

        return new int[] { row, col };
    }
}
