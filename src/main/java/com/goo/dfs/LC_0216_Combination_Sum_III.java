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
import java.util.List;

public class LC_0216_Combination_Sum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(k, n, 1, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int k, int n, int start, List<List<Integer>> res, List<Integer> path, int sum) {
        if (sum > n || path.size() > k) {
            return;
        } else if (sum == n && path.size() == k) {
            res.add(new ArrayList<>(path));
        }

        for (int i = start; i <= 9; i++) {
            path.add(i);
            dfs(k, n, i+1, res, path, sum + i);
            path.remove(path.size()-1);
        }
    }
}
