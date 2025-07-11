package com.leetcode.binarySearch;

public class LC_0034_searchRange {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;

        int leftMost = nums.length -1;
        int rightMost= 0;

        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                int i  = mid;
                while (i <= right && nums[i] == target) {
                    rightMost = Math.max(rightMost, i);
                    i++;
                }
                i  = mid;
                while (i >= left && nums[i] == target) {
                    leftMost = Math.min(rightMost, i);
                    i--;
                }
                return new int[]{leftMost, rightMost};


            } else if (target < nums[mid]){
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }

        return new int[] {-1, -1};
    }
}
