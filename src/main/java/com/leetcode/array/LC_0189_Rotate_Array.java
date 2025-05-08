package com.leetcode.array;

public class LC_0189_Rotate_Array {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (k == 0 || k == len || k > len &&  k%len == 0) {
            // do nothing
            return;
        }
        k = k % len;

        // Step 1: Reverse the whole array
        reverse(nums, 0, len - 1);
        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Step 3: Reverse the remaining n-k elements
        reverse(nums, k, len - 1);


    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
