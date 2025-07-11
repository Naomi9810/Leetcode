package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC_0046_Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res =  new ArrayList<>();
        dfs(res, nums, new ArrayList<>());
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, List<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int num: nums) {
            if (!path.contains(num)) {
                path.add(num);
                dfs(res, nums, path);
                path.removeLast();
            }
        }


    }
}
