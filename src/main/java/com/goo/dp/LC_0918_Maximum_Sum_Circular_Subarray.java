/**
 * Created by Sijia on 12/19/21
 * Time Complexity:
 * <p> O(N)
 * Space Complexity:
 * <p> o(1)
 * Hints:
 * <p> 1. https://leetcode.com/problems/maximum-sum-circular-subarray/discuss/178422/One-Pass
 * <p> 2. similar to 152, need to keep track of the max and min
 * <p> 3.
 * Case 1. The first is that the subarray take only a middle part, and we know how to find the max subarray sum.
 * Case2. The second is that the subarray take a part of head array and a part of tail array.
 * We can transfer this case to the first one.
 * The maximum result equals to the total sum minus the minimum subarray sum.
 */

package com.goo.dp;

public class LC_0918_Maximum_Sum_Circular_Subarray {
    public int maxSubarraySumCircular(int[] nums) {
        int max, min, sum, maxSum, minSum;
        max = min = sum = maxSum = minSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max + nums[i]);
            maxSum = Math.max(maxSum, max);

            min = Math.min(nums[i], min + nums[i]);
            minSum = Math.min(minSum, min);

            sum += nums[i];
        }
        return maxSum > 0 ? Math.max(maxSum, sum - minSum) : maxSum;
        //  if maxSum < 0 means all the element are negative, only pick the largest number sum == minSum, sum - minSum == 0
    }
}
