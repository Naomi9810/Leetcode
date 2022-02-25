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

package com.goo.dp;

public class LC_0238_Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1]; // 左一遍 从1开始
        }
        int right = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            res[j] *= right;
            right *= nums[j]; // 右一遍 找一个right 让右边第一个不要乘
        }
        return res;
    }
}
