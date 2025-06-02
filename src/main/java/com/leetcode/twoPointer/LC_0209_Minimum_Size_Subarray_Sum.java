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

public class LC_0209_Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            if (num >= target)
                return 1;
            sum += num;
        }
        if (sum < target)
            return 0;
        if (sum == target)
            return len;

        sum = 0;
        // create a window, if meet,add res, not meet move right
        int minLen = len;
        int left = 0;
        for (int right = 0; right < len; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }

        }
        return minLen;

    }
}
