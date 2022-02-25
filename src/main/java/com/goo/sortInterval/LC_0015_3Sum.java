/**
 * Created by Sijia on 2/18/22
 * Time Complexity:
 * <p>  NlogN  + N^2 = N^2
 * Space Complexity:
 * <p> N
 * Hints: 用i去loop， j=i+1  i+1 < len-1    k做右边指针
 * https://leetcode.com/problems/3sum/discuss/143636/Java-with-set
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.sortInterval;

import java.util.*;

public class LC_0015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) { // 第一次dedup
                twoSum(nums, i, res);
            }
        }
        return res;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int left = i + 1, right = nums.length - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum == 0) {
                res.add(Arrays.asList(nums[i], nums[left++], nums[right--])); // don't forget to move forward
                while (left < right && nums[left] == nums[left - 1]) {
                    left++; // 第二次dedup
                }
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }
}
