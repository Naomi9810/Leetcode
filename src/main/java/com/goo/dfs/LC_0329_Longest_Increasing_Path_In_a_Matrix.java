package com.goo.dfs;

/**
 * Time Complexity: O(M*N) - m = grid.length, n = grid[0].length.
 * <p>
 * Space Complexity: O(M*N) - m = grid.length, n = grid[0].length.
 * <p>
 * Hints:
 * <p> 1. base case 1 - increasing is true. equal/decrease - is false. </>
 * <p> 2. enter: not visited = 0, if already visited directly return mem value </>
 */
public class LC_0329_Longest_Increasing_Path_In_a_Matrix {

    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        int[][] mem = new int[matrix.length][matrix[0].length];
        // used to memorize the longest path use current index as start point
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, dfs(matrix, mem, i, j));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int[][] mem, int i, int j) {
        if (!validIdx(i, j, matrix.length, matrix[0].length)) {
            return 0;
        }
        if (mem[i][j] != 0) {
            return mem[i][j];
        }
        // mark visited
        mem[i][j] = 1;
        // four direction:
        // up
        if (validIdx(i - 1, j, matrix.length, matrix[0].length) && matrix[i - 1][j] > matrix[i][j]) {
            mem[i][j] = Math.max(mem[i][j], dfs(matrix, mem, i - 1, j) + 1);
        }
        // down
        if (validIdx(i + 1, j, matrix.length, matrix[0].length) && matrix[i + 1][j] > matrix[i][j]) {
            mem[i][j] = Math.max(mem[i][j], dfs(matrix, mem, i + 1, j) + 1);
        }
        // left
        if (validIdx(i, j - 1, matrix.length, matrix[0].length) && matrix[i][j - 1] > matrix[i][j]) {
            mem[i][j] = Math.max(mem[i][j], dfs(matrix, mem, i, j - 1) + 1);
        }
        // right
        if (validIdx(i, j + 1, matrix.length, matrix[0].length) && matrix[i][j + 1] > matrix[i][j]) {
            mem[i][j] = Math.max(mem[i][j], dfs(matrix, mem, i, j + 1) + 1);
        }
        return mem[i][j];
    }

    private boolean validIdx(int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return false;
        } else {
            return true;
        }
    }
}
