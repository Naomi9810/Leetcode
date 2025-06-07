package com.leetcode.mathBitMatrix;

public class LC_0289_Game_of_Life {
    public void gameOfLife(int[][] board) {
        // live < 2 -> dead
        // live 2,3 -> live
        // live > 3 -> dead
        // dead with live == 3 -> live

        // two status
        //  live-> dead   -1
        //  dead -> live -> 2

        int row = board.length;
        int col = board[0].length;

        // run one time to check status and record
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 0 && canLive(board, i, j))  {
                    board[i][j] = 2;
                }
                if (board[i][j] == 1 && !canLive(board, i, j)) {
                    board[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == -1) board[i][j] = 0;
                if (board[i][j] == 2) board[i][j] = 1;
            }
        }
    }

    public boolean canLive(int[][] board, int i, int j) {
        int init = board[i][j];
        int count = lifeCount(board, i,j);
        if (init == 0 && count == 3) return true;
        return init == 1 && (count == 2 || count == 3);

    }

    public int lifeCount(int[][] board, int i, int j){
        int count = 0;
        int row = board.length;
        int col = board[0].length;

        for (int x = -1; x <=1; x++) {
            for (int y = -1; y <=1; y++) {
                int i2 = i + x;
                int j2 = j + y;
                if (i2 >=0 && j2 >=0 && i2< row && j2< col ) {
                    if (x == 0 && y == 0) continue;
                    if (board[i2][j2] == 1 || board[i2][j2] == -1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
