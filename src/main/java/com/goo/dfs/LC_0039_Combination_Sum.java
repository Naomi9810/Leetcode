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

package com.goo.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_0039_Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        combination(candidates, target, new ArrayList<>(), 0, res);
        return res;
    }

    private void combination(int[] candidates, int target, List<Integer> path, int start, List<List<Integer>> res) {
        // base case:
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(path));
        }

        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            combination(candidates, target - candidates[i], path, i, res);
            path.remove(path.size()-1);
        }
    }

}
