/**
 * Created by Sijia on 12/27/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * <p> 1. build the ones matrix, calculate the 连续的 1 since first row
 * <p> 2. use the same concept in trapping water-42 and histogram calculation-84, when to calculate the area? smaller number -> so keeping an increasing stack
 * <p> 3.
 */

package com.leetcode.stack;

import java.util.Stack;

public class LC_0085_Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] ones = new int[row][col];
        onesInCol(matrix, ones, row, col);
        int max = 0;
        for (int i = 0; i < row; i++) {
            max = Math.max(max, maxRec(ones[i]));
        }
        return max;
    }

    private void onesInCol(char[][] matrix, int[][] ones, int row, int col) {
        for (int j = 0; j < col; j++) {
            ones[0][j] = matrix[0][j] == '1' ? 1 : 0; // first row same as matrix
        }
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ones[i][j] = matrix[i][j] == '1' ? 1 + ones[i - 1][j] : 0; // each row is the continuous count of ones since first row.
            }
        }
    }

    /*
    @Return the max rectangle in a row
     */
    private int maxRec(int[] row) {
        int len = row.length, max = 0, area = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= len; i++) {
            int height = i < len ? row[i] : 0;
            while (!stack.isEmpty() && height < row[stack.peek()]) {
                int top = stack.pop(); // top is the largest
                int start = stack.isEmpty() ? -1 : stack.peek();
                area = row[top] * (i - start - 1);
                max = Math.max(max, area);
            }
            stack.push(i);
        }
        return max;
    }
}
