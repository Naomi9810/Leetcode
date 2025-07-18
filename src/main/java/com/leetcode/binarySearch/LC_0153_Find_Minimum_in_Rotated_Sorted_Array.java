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
        int left = 0;
        int right = nums.length - 1;
        int min = nums[0];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            min = Math.min(min, nums[mid]);
            // If the right half is sorted, min must be on the left or at mid
            if (nums[mid] < nums[right]) {
                right = mid - 1;
            } else {
                // Left half is sorted, min must be on the right
                left = mid + 1;
            }
        }
        return min;
    }
}
