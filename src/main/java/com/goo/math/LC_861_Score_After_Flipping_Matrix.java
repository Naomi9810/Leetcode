/**
 * Created by Sijia on 1/18/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: making the leftmost col all 1, trying to make more 1
 * <p> 1. make it simple just comparing the 1 with the grid[i][0] to determine if this row is flipped
 * <p> 2.
 * <p> 3.
 */

package com.goo.math;

public class LC_861_Score_After_Flipping_Matrix {
    public int matrixScore(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        // first col making all 1
        int score = row * (1 << (col - 1));


        // flip the rest col as many as possible without changing first col
        for (int j = 1; j < col; j++) {
            int count = 0;
            for (int i = 0; i < row; i++) {
                count += grid[i][j] == grid[i][0] ? 1 : 0; //  the number of ones
            }
            score += Math.max(count, row - count) * (1 << (col - 1 - j));
        }
        return score;
    }
}
