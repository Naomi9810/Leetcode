package com.leetcode.twoPointer;

public class LC_2302_Count_Subarrays_Less_Than_K {
    public long countSubarrays(int[] nums, long k) {
        long res = 0, partSum = 0; // make sure this is long out of bound
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            partSum += nums[right];
            while (partSum * (right - left + 1) >= k) {
                partSum -= nums[left++];
            }
            res += right - left + 1;
        }
        // two pointer sliding window:
        //  i left bound, j right bound
        // when j moves, add nums[j] to sum
        // when break rules, move left bound
        // For the valid window nums[left..right], all subarrays ending at right are valid.
        //The number of such subarrays is window_length = right - left + 1
        /*
        nums[left..right]
        nums[left+1..right]
        nums[left+2..right]
        ...
        nums[right..right] (single-element subarray)
         */
        return res;
    }


}
