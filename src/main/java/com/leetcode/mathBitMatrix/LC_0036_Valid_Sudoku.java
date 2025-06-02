package com.leetcode.mathBitMatrix;

import java.util.HashSet;
import java.util.Set;

public class LC_0036_Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                if (number == '.') continue;
                if ( !seen.add(number + "row" + i) ||
                        !seen.add(number + "col" + j) ||
                        !seen.add(number + "block" + i/3 + j/3)
                ) {
                    return false;
                }

            }
        }
        return true;
    }
}
