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

package com.goo.twoPointer;

public class LC_0167_Two_Sum_Input_Array_Sorted {
    public int[] twoSum(int[] numbers, int target) {
        // two pointer
        int left = 0, right = numbers.length -1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left+1, right+1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }

}
