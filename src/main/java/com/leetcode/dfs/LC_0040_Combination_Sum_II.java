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

package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_0040_Combination_Sum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        combination(candidates, 0, res, new ArrayList<>(), target);
        return res;
    }
    private void combination(int[] candidates, int start, List<List<Integer>> res, List<Integer> path, int target) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            combination(candidates, i+1, res, path, target - candidates[i]);
            path.remove(path.size()-1);
            while (i + 1 < candidates.length && candidates[i+1] == candidates[i]) {
                i++;
            }
        }
    }
}
