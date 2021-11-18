package com.goo.dp;

/**
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations
 * /discuss/1075469/JavaC%2B%2BPython-3-Top-Down-DP-O(m2)-Clean-and-Concise
 * <p> 2. dp problem. In operation ith, we can choose to pick the left or the right side of nums
 * <p> 3. k is the number we need to pick, which == the multipliers.length
 * dp means
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
    // left idx, i is the ith element we picked, start from 0
    if (i == k) {
      return 0; // picked enough k elements
    }
    if (mem[left][i] != null) {
      return mem[left][i];
    }
    int pickLeft = dp(left + 1, i + 1) + nums[left] * muls[i];
    int pickRight = dp(left, i + 1) + nums[len - 1 - (i - left)] * muls[i];
    mem[left][i] = Math.max(pickLeft, pickRight);
    return mem[left][i];
  }
}
