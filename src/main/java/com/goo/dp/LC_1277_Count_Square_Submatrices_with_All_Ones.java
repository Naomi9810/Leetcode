package com.goo.dp;

/**
 * Time Complexity:
 * <p> O(M*N) M is row, N is col
 * Space Complexity:
 * <p> O(1) reuse the matrix itself
 * Hints:
 * <p> 1.dp[i][j] means the size of the biggest square with A[i][j] as bottom-right corner.
 * <p> dp[i][j] also means the number of squares with A[i][j] as bottom-right corner.
 * <p> 2. if i == 0 || j == 0 , matrix[i][j] = res
 * <p> 3. 0 1      1           1
 * <p>    0 1 dp[i-1][j-1] dp[i][j-1]
 * <p>    0 1 dp[i-1][j]   dp[i][j]
 */
public class LC_1277_Count_Square_Submatrices_with_All_Ones {

  public int countSquares(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    int res = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (matrix [i][j] > 0 && i > 0 && j > 0) {
          matrix[i][j] = Math.min(matrix[i-1][j-1], Math.min(matrix[i][j-1], matrix[i][j-1])) + 1;
        }
        res += matrix[i][j];
      }
    }
    return res;
  }

}
