/**
 * Created by Sijia on 2/20/22
 * Time Complexity:
 * <p> O(N)
 * Space Complexity:
 * <p> O(N)
 * Hints: 基本讨论 存 count  计算presum
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class LC_0560_Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // sum, count
        int sum = 0;
        int count = 0;
        map.put(sum, 1);
        for (int num: nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
