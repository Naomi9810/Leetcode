package com.goo.dp;

/**
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */
public class LC_1770_Maximum_Score_Multiplication_Operations {

  int len, k;
  int[] nums, muls;
  Integer[][] mem;

  public int maximumScore(int[] nums, int[] multipliers) {
    len = nums.length;
    k = multipliers.length;
    this.nums = nums;
    this.muls = multipliers;
    this.mem = new Integer[k][k];
    return dp(0, 0);
  }

  private int dp(int left, int i) {
    // left idx, i is the ith element we picked
    if (i == k) {
      return 0; // picked enough k elements
    }
    if (mem[left][i] != null) {
      return mem[left][i];
    }
    int pickLeft = dp(left + 1, i + 1) + nums[left] * muls[i];
    int pickRight = dp(left, i + 1) + nums[len - 1 - (i - left)] * muls[i];
    return mem[left][i] = Math.max(pickLeft, pickRight);
  }
}
