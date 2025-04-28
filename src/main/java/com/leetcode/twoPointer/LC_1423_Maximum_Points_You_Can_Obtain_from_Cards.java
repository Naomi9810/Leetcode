package com.leetcode.twoPointer;

/**
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. pay attention to the remove, add order
 * <p> 2.
 * <p> 3.
 */
public class LC_1423_Maximum_Points_You_Can_Obtain_from_Cards {

  public int maxScore(int[] cardPoints, int k) {
    // corner case:
    if (cardPoints == null || cardPoints.length == 0) {
      return 0;
    }
    // calculate the first k numbers:
    int sum = 0;
    for (int i = 0; i < k; i++) {
      sum += cardPoints[i];
    }
    int max = sum;
    int len = cardPoints.length;
    int left = 0;
    int right = k - 1;

    while (right < len - 1) {
      // calculate remove first in the original place
      int remove = cardPoints[right--];
      left--;
      if (left < 0) {
        left = len - 1;
      }
      if (right < 0) {
        right = len - 1;
      }
      int add = cardPoints[left];
      sum = sum - remove + add;
      max = Math.max(max, sum);
    }
    return max;
  }

}
