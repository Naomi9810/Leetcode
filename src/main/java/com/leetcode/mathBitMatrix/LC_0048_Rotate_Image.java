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

public class LC_0048_Rotate_Image {
    public void rotate(int[][] matrix) {
        // input validation
        int n = matrix.length;
//         for (int i = 0; i < (n+1)/2; i++) {
//             for (int j = 0; j < n/2; j++) {

//                 int temp = matrix[n-j-1][i];
//                 matrix[n -j-1][i] = matrix[n - i - 1][n-j-1];
//                 matrix[n - i - 1][n-j-1] = matrix[j][n - i - 1];
//                 matrix[j][n - i - 1] = matrix[i][j];
//                 matrix[i][j] = temp;
//             }
//         }
        transpose(matrix);
        reflect(matrix);
    }

    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    public void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}
