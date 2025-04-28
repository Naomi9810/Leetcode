/**
 * Created by Sijia on 1/22/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p> O(1000 ^2)
 * Hints: axis-aligned square
 * <p> 1. 点是有限的的 用 matrix 记录点的位置
 * <p> 2. 找到对角线的点 条件是 1. 点不能相同 x1-x2 == y1-y2
 * <p> 3. 用matrix 另外两点的 乘积 ++
 */

package com.leetcode.mathBitMatrix;

import java.util.ArrayList;
import java.util.List;

public class LC_2013_Detect_Squares {
    int[][] count = new int[1001][1001];
    List<int[]> points;

    public void DetectSquares() {
        count =  new int[1001][1001];
        points = new ArrayList<>();
    }

    public void add(int[] point) {
        count[point[0]][point[1]]++;
        points.add(point);
    }

    public int count(int[] point) {
        int i = point[0], j = point[1], res = 0;
        for (int[] p: points) {
            int i2 = p[0], j2 = p[1];
            if (i == i2 || Math.abs(i - i2) != Math.abs(j - j2)) continue;
            res += count[i][j2] * count[i2][j];
        }
        return res;
    }
}
