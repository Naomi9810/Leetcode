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

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (searchHelper(board, word, i, j, 0)) {
                    return true;
                }

            }
        }
        return false;
    }

    public boolean searchHelper(char[][] board, String word, int i, int j, int idx) {
        if (idx == word.length()) return true;

        int row = board.length;
        int col = board[0].length;

        if (i < 0 || j < 0 || i >= row || j >= col || board[i][j] == '#') return false; // visited or oob

        if (board[i][j] != word.charAt(idx)) return false;

        board[i][j] = '#';

        boolean res = searchHelper(board, word, i + 1, j, idx + 1) ||
                searchHelper(board, word, i - 1, j, idx + 1) ||
                searchHelper(board, word, i, j + 1, idx + 1) ||
                searchHelper(board, word, i, j - 1, idx + 1);
        board[i][j] = word.charAt(idx);
        return res;
    }
}
