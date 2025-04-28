/**
 * Created by Sijia on 2/3/22
 * https://leetcode.com/problems/shuffle-an-array/discuss/85958/First-Accepted-Solution-Java
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * https://blog.codinghorror.com/the-danger-of-naivete/
 * for position 0, we choose a random number nums[i] from nums[0 : n-1], put it to nums[0](actually swap it with nums[0] such that we can follow the following rules);
 * for position 1, we choose a random number nums[i] from nums[1 : n-1], put it to nums[1], (...);
 * for position 2, we choose a random number nums[i] from nums[2 : n-1], put it to nums[2], (...);
 *
 * for (int i = cards.Length - 1; i > 0; i--)
 * {
 *   int n = rand.Next(i + 1);
 *   Swap(ref cards[i], ref cards[n]);
 * }
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.mathBitMatrix;

import java.util.Random;

public class LC_0384_Shuffle_an_Array {
    int[] nums;
    Random rdm;

    public void Solution(int[] nums) {
        this.nums = nums;
        rdm = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        if (nums == null) return null;
        int[] copy = nums.clone();
        for (int i = copy.length - 1; i >= 0; i--) {
            int j = rdm.nextInt(i+1); // pick from range [i, len-i) 的 idx
            // 第一次是 0， 选择是从 0 到 len-1
            // 第二次是 1， 选择是从 1 到 len-1
            swap(copy, i, j);
        }
        return copy;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
