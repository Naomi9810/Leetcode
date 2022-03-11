/**
 * Created by Sijia on 2/17/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.mathMatrix;


public class LC_0031_Next_Permutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) i--; // find the 1st i that breaks the descending order
        if (i >= 0) {
            // curren nums[i] < nums[i+1];
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--; // Find rightmost first larger id j
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1); //why need reverse, think the example of 321 -> 123

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while (i < j) swap(A, i++, j--);
    }
}
