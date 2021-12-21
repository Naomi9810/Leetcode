/**
 * Created by Sijia on 12/19/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. Same as 0053, need to store the max and min, because the min will be max if the num is negative
 * <p> 2.
 * <p> 3.
 */

package com.goo.dp;

public class LC_0152_Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int max = nums[0], min = nums[0], res = nums[0];

        for (int i = 1; i < len; i++) {
            int maxProduct = max * nums[i];
            int minProduct = min * nums[i];
            max = Math.max(nums[i], Math.max(maxProduct, minProduct));
            min = Math.min(nums[i], Math.min(maxProduct, minProduct));

            res = Math.max(res, max);
        }
        return res;
    }
}
