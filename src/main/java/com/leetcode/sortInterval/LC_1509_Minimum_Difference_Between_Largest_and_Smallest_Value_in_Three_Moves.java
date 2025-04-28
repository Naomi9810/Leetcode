package com.leetcode.sortInterval;

import java.util.Arrays;

/**
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: We have 4 plans:
 * <p> kill 3 biggest elements: dif = A[n-4] - A[0]
 * <p> kill 2 biggest elements + 1
 * <p> smallest elements  A[n-3] - A[1]
 * <p> kill 1 biggest elements + 2 smallest elements A[n-2] - A[2] kill
 * 3 smallest elements A[n-1] - A[4]
 */
public class LC_1509_Minimum_Difference_Between_Largest_and_Smallest_Value_in_Three_Moves {

  public int minDifference(int[] nums) {
    int len = nums.length;
    if (len < 5) {
      return 0;
    }
    // sort the whole array, then pick left 3 or pick right 3, find the min dif
    int res = Integer.MAX_VALUE;
    Arrays.sort(nums);
    for (int i = 0; i < 4; i++) {
      res = Math.min(nums[len - 4 + i] - nums[i], res);
    }
    return res;
  }

}
