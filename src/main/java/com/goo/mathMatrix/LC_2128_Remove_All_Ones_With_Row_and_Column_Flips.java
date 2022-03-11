/**
 * Created by Sijia on 1/18/22
 * Time Complexity:
 * <p> O(M*N)
 * Space Complexity:
 * <p>
 * Hints: flip的顺序没有关系 因为因为一个cell 要么是0 要么是 1
 * <p> 1. Greedy 找到第一排 所有的1 每次遇到之后 就把它的这个column flip
 * <p> 2. 从第二排开始 不能再翻转column了 因为会破坏第一排，只能翻转row 如果这个row 不是全部 1 或者全部0 就不能成功
 * <p> 3.
 */

package com.goo.mathMatrix;

public class LC_2128_Remove_All_Ones_With_Row_and_Column_Flips {
    public boolean removeOnes(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        // check the first row
        for (int j = 0; j < col; j++) {
            if (grid[0][j] == 1) {
                flipCol(j, grid);
            }
        }

        // check from second row
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != grid[i][j-1]) { // all 1s or all 0s
                    return false;
                }
            }
        }
        return true;
    }

    private void flipCol(int j, int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            grid[i][j] = 1 - grid[i][j];
        }
    }
}
