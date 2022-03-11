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

package com.goo.dfs;

public class LC_0079_Word_Search {
    public boolean exist(char[][] board, String word) {
        // validation
        int col = board[0].length;
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == wordArr[0]) {
                    board[i][j] = '#';
                    if (dfs(board, i, j, 1, wordArr)) {
                        return true;
                    }
                    board[i][j] = wordArr[0];
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int pos, char[] wordArr) {
        if (pos == wordArr.length) return true;
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int col = board[0].length;

        for (int[] d: dir) {
            int i2 = i + d[0];
            int j2 = j + d[1];
            if (i2 < 0 || j2 < 0 || i2 >= board.length || j2 >= col || board[i2][j2] == '#' || board[i2][j2] != wordArr[pos]) continue;
            board[i2][j2] = '#';
            if (dfs(board, i2, j2, pos+1, wordArr)){
                return true;
            }
            board[i2][j2] = wordArr[pos];
        }
        return false;
    }
}
