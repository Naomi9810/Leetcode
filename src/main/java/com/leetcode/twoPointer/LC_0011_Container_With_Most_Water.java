/**
 * Created by Sijia on 2/23/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.twoPointer;

public class LC_0011_Container_With_Most_Water {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = height.length-1;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            res = Math.max( res, h * (right - left)); // width 的计算注意带值进去算
            if (height[left] < height[right]) {
                left++; // 从最宽开始 去短板 试图留住大的
            } else {
                right--;
            }
        }
        return res;


    }
}
