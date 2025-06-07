package com.leetcode.mathBitMatrix;

public class LC_0073_Set_Matrix_Zero {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        boolean firstRow = false, firstCol = false;

        // Check first row and column
        for (int c = 0; c < cols; c++) firstRow |= (matrix[0][c] == 0);
        for (int r = 0; r < rows; r++) firstCol |= (matrix[r][0] == 0);

        // Use first row and column as markers
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        // Zero cells based on markers
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        // Zero first row and column if needed
        if (firstRow) for (int c = 0; c < cols; c++) matrix[0][c] = 0;
        if (firstCol) for (int r = 0; r < rows; r++) matrix[r][0] = 0;
    }
}
