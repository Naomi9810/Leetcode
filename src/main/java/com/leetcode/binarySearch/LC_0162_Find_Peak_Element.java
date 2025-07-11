package com.leetcode.binarySearch;

public class LC_0162_Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums.length == 2) return nums[0] > nums[1]? 0:1;

        int left = 0; int right = nums.length -1;

        while (left <  right) {
            int mid = left + (right - left)/2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
