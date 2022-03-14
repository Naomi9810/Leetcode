/**
 * Created by Sijia on 3/11/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.twoPointer;

public class LC_0713_Subarray_Product_LessThan_K {
    /*
   [10,5,2,6]
   100
   left: right
   0:0 [10]       -> 1
   0:1 [5] [10,5] -> 2
   1:2 [2] [5, 2] -> 2
   1:3 [6] [2, 6] [5, 2, 6] -> 3
   */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0; // corner case
        // two pointer
        int product = 1;
        int len = nums.length;
        int left = 0;
        int res = 0;
        for (int right = 0; right < len; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left++];
            }
            res += right - left + 1;
        }
        return res;
    }
}
