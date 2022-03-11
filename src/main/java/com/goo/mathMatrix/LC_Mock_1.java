/**
 * Created by Sijia on 1/31/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * 1. brute force: based from the given start and end idx to do a loop
 * for (int i = left[0]; i <= right[0]; i++) {
 *     for (int j = left[1]; j <= right[1]; j++) {
 *         sum += matrix[i][j];
 *     }
 * }
 * Improvement
 * to calculate the preSum matrix
 * to save the space reuse the matrix
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.mathMatrix;

public class LC_Mock_1 {
    public int sumOfSubMatrix(int[] left, int[] right, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int pre = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] += pre;
                pre = matrix[i][j];
            }
        }

        int res = 0;
        for (int i = left[0]; i <= right[0]; i++) {
            res += matrix[i][right[1]] - matrix[i][left[1]];
        }
        return res;
    }
}
