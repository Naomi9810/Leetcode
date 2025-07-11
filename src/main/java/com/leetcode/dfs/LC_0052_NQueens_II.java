package com.leetcode.dfs;

import java.util.HashSet;
import java.util.Set;

public class LC_0052_NQueens_II {
    int res = 0;

    public int totalNQueens(int n) {
        dfs(0, n, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return res;
    }

    // row: current row being placed
    // cols: used columns
    // diag1: used main diagonals (row - col)
    // diag2: used anti-diagonals (row + col)
    public void dfs(int row, int n, Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2) {
        if (row == n) {
            res++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col;
            int d2 = row + col;

            if (cols.contains(col) || diag1.contains(d1) || diag2.contains(d2)) {
                continue;
            }

            cols.add(col);
            diag1.add(d1);
            diag2.add(d2);

            dfs(row + 1, n, cols, diag1, diag2);

            // backtrack
            cols.remove(col);
            diag1.remove(d1);
            diag2.remove(d2);
        }
    }
}
