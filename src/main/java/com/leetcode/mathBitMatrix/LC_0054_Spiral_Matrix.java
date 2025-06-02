package com.leetcode.mathBitMatrix;

import java.util.ArrayList;
import java.util.List;

public class LC_0054_Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;
        int top = 0, bottom = matrix.length - 1; // i
        int left = 0, right = matrix[0].length - 1; // j

        while (top <= bottom && left <= right) {
            // left -> right
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            top++;

            // top -> bottom
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            // right -> left
            for (int j = right; j >= left && top <= bottom; j--) {
                res.add(matrix[bottom][j]);
            }
            bottom--;

            // bottom -> top
            for (int i = bottom; i >= top && left <= right; i--) {
                res.add(matrix[i][left]);

            }
            left++;

        }
        return res;
    }
}
