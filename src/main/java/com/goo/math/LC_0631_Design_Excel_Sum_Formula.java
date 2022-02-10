/**
 * Created by Sijia on 2/4/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.math;

import java.util.Arrays;

public class LC_0631_Design_Excel_Sum_Formula {
    int[][] matrix;

    public void Excel(int height, char width) {
        matrix = new int[height][width - 'A'];
        for (int [] row: matrix) {
            Arrays.fill(row, 0);
        }
    }

    public void set(int row, char column, int val) {
        int pre = matrix[row - 1][column - 'A'];
        matrix[row - 1][column - 'A'] = val;

    }

    public int get(int row, char column) {
        return

    }

    public int sum(int row, char column, String[] numbers) {

    }
}
