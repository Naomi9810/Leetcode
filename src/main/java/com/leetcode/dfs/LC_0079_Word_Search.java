/**
 * Created by Sijia on 3/9/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>  search 一个word 可以用 bfs 如果是很多word 可以用word 新建一个trie
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.dfs;

public class LC_0079_Word_Search {
    public boolean exist(char[][] board, String word) {
        char[] charArr = word.toCharArray();
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, visited, 0, i, j, charArr)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int idx, int i, int j, char[] charArr) {
        // base case:
        if (idx == charArr.length) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false; // out of bound
        if (board[i][j] != charArr[idx] || visited[i][j]) return false; // not meeting requirement

        visited[i][j] = true;
        if (dfs(board, visited, idx + 1, i + 1, j, charArr)) return true;
        if (dfs(board, visited, idx + 1, i - 1, j, charArr)) return true;
        if (dfs(board, visited, idx + 1, i, j + 1, charArr)) return true;
        if (dfs(board, visited, idx + 1, i, j - 1, charArr)) return true;
        visited[i][j] = false;
        return false;
    }
}
