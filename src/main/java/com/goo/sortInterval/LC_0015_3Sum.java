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
        if (nums == null || nums.length <= 2) return Collections.emptyList();
        Set<List<Integer>> set = new HashSet<>(); // use set to remove the same triple
        Arrays.sort(nums);
        for (int i = 0; i + 1 < nums.length - 1; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
