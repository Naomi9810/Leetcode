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

package com.leetcode.dp;

public class LC_0238_Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        int left = 1;
        for (int i = 0; i < len; i++) {
            res[i] = left;
            left *= nums[i];
        }

        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }

        return res;
    }
}
