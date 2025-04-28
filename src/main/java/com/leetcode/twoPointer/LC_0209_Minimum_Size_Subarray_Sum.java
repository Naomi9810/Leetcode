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
//         int sum = 0;
//         int res = Integer.MAX_VALUE;
//         TreeMap<Integer,Integer> map = new TreeMap<>();
//         map.put(0, -1); // full length
//         for (int i = 0; i < nums.length; i++) {
//             sum += nums[i];
//             map.put(sum, i);
//             if (map.floorEntry(sum - target) != null) {
//                 res = Math.min(res, i - map.floorEntry(sum-target).getValue());
//             }
//         }
//         return res == Integer.MAX_VALUE? 0: res;

        int left = 0, right = 0;
        int res = Integer.MAX_VALUE, sum = 0;

        while (right < nums.length) {
            sum += nums[right];

            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }

        return res == Integer.MAX_VALUE? 0: res;

    }
}
