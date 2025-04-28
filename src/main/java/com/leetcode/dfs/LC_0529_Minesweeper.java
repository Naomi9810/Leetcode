package com.leetcode.dfs;

/**
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. if M is revealed then the game is over M -> X
 * <p> 2. E -> B adjacent E will reveal recursively
 * <p> 3. E -> number will only reveal itself if there is a M Need to check 8 direction
 */
public class LC_0529_Minesweeper {

    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0];
        int j = click[1];
        if (board[i][j] == 'M') {
            // case 1 game over
            board[i][j] = 'X';
        } else if (board[i][j] == 'E') {
            dfs(board, i, j);
        }
        return board;
    }

    private void dfs(char[][] board, int i, int j) {
        int mineCount = numOfMine(board, i, j);
        if (mineCount == 0) {
            // recursively reveal the adjacent empty cell
            board[i][j] = 'B';
            int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1},
                    {1, -1}};
            for (int[] d : direction) {
                int i2 = i + d[0];
                int j2 = j + d[1];
                if (i2 >= 0 && j2 >= 0 && i2 < board.length && j2 < board[0].length && board[i2][j2] == 'E') {
                    dfs(board, i2, j2);
                }
            }
        } else {
            board[i][j] = (char) (mineCount + '0');
        }
    }

    private int numOfMine(char[][] board, int i, int j) {
        // check 9 direction to see if there is a mine:
        int count = 0;
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1},
                {1, -1}};
        for (int[] d : direction) {
            int i2 = i + d[0];
            int j2 = j + d[1];
            if (i2 >= 0 && j2 >= 0 && i2 < board.length && j2 < board[0].length && board[i2][j2] == 'M') {
                count++;
            }
        }
        return count;
    }
}
