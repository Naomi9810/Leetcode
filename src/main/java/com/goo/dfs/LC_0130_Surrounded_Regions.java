package com.goo.dfs;

/**
 * Time Complexity: O(N) N is the grid size
 * <p>
 * Space Complexity: O(M) - N is grid size
 * <p>
 * Hints:
 * <p> 1. Same idea as the 1254 but instead of counting the numbers, we need to flip the cell
 * <p> 2. So the idea is to first use do dfs for 4 boundary to find those no surrounded regions
 * <p> 3. the go through the board to clean
 */

public class LC_0130_Surrounded_Regions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        // do dfs for the four boundaries
        for (int j = 0; j < board[0].length; j++) {
            // first and last row
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[board.length - 1][j] == 'O') {
                dfs(board, board.length - 1, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            // first and last col
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                dfs(board, i, board[0].length - 1);
            }
        }

        // clean and set the right value:
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    /**
     * dfs search 4 direction, flip all 'O' to 'V'
     */
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up/down/left/right
        board[i][j] = 'V';
        for (int[] d : directions) {
            int i2 = i + d[0];
            int j2 = j + d[1];
            dfs(board, i2, j2);
        }
    }
}
