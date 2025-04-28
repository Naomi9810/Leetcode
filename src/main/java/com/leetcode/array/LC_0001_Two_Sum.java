/**
 * Created by Sijia on 12/8/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC_0001_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idxMap = new HashMap<Integer, Integer>(); // key is number, value is idx
        for (int i = 0; i < nums.length; i++) {
            if (idxMap.containsKey(target - nums[i])) {
                return new int[]{idxMap.get(target - nums[i]), i};
            } else {
                idxMap.put(nums[i], i);
            }
        }
        return new int[] {};
    }

}
