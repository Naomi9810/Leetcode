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

package com.leetcode.twoPointer;

import java.util.Arrays;

public class LC_1099_Two_Sum_Less_Than_K {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0; int right = nums.length  -1;
        int res = Integer.MIN_VALUE;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                left++;
                res = Math.max(res, sum);
            } else {
                right--;
            }
        }
        return res == Integer.MIN_VALUE? -1: res;
    }
}
