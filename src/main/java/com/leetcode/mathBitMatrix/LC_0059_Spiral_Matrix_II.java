/**
 * Created by Sijia on 3/7/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.mathBitMatrix;

public class LC_0059_Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int num = 1;
        int start = 0, end = n;
        while (num <= n * n) {
            for (int j = start; j < end; j++) {
                matrix[start][j] = num++;
            }

            for (int i = start + 1; i < end; i++) {
                matrix[i][end - 1] = num++;
            }

            for (int j = end - 2; j >= start; j--) {
                matrix[end - 1][j] = num++;
            }
            for (int i = end - 2; i > start; i--) {
                matrix[i][start] = num++;
            }
            start++;
            end--;
        }
        return matrix;
    }
}
