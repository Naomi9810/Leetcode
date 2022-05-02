/**
 * Created by Sijia on 2/19/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. first round remove negative and larger than len+1
 * <p> 2.
 * <p> 3.
 */

package com.goo.mathBitMatrix;

public class LC_0041_First_Missing_Positive {
    public int firstMissingPositive(int[] nums) {
        // max = nums.length +1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len) {
                nums[i] = len + 1; // mark as visited
            }
        }

        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]); // 先拿到这个数字 看是不是在范围之内 如果在 再-- 拿来当idx
            if (num > len) {
                continue;
            }
            if (nums[--num] > 0) {
                nums[num] = -nums[num];
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }
        return len + 1;
    }
}
