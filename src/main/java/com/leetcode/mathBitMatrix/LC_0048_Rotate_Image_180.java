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

public class LC_0048_Rotate_Image_180 {
    public void rotate(int[][] matrix) {
        /*
        *   [  1,  2,  3,  4 ]
            [  5,  6,  7,  8 ]
            [  9, 10, 11, 12 ]
            [ 13, 14, 15, 16 ]
            *
            *
            [ 13, 14, 15, 16 ]
            [  9, 10, 11, 12 ]
            [  5,  6,  7,  8 ]
            [  1,  2,  3,  4 ]

        * */
        int n = matrix.length;

        // Flip the matrix vertically (reverse rows)
        for (int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n - 1 - i];
            matrix[n - 1 - i] = temp;
        }

        // Flip each row horizontally (reverse each row)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }

}
