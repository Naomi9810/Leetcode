/**
 * Created by Sijia on 3/15/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.dp;

public class LC_0377_Combination_Sum_IV {
    public int combinationSum4(int[] nums, int target) {
        Integer [] mem = new Integer[target+1];
        dfs(nums, target, mem);
        return mem[target];
    }

    private int dfs(int[] nums, int target, Integer[] mem) {
        if (target < 0) {
            return 0;
        } else if (target == 0) {
            return 1;
        }
        if (mem[target] != null) {
            return mem[target];
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                res += dfs(nums, target - nums[i], mem);
            }
        }
        mem[target] = res;
        return res;
    }
}
