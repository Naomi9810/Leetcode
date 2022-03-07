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

package com.goo.binarySearch;

public class LC_0033_Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid]) {
                // first half not rotated:
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid +1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    // 等于统一出现再 left and right
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }
}
