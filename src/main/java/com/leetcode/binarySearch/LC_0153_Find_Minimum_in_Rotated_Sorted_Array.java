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

package com.leetcode.binarySearch;

public class LC_0153_Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0, right = nums.length - 1;
        if (nums[left] < nums[right]) {
            // not rotate
            return nums[left];
        }


        while (left + 1 < right) {
            // 第三种binary search的模板 用来找当前idx或者左右邻居
            // https://leetcode.com/explore/learn/card/binary-search/135/template-iii/936/
            int mid = left + (right - left)/2;
            if (nums[left] > nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
