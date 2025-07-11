package com.leetcode.dfs;

import java.util.*;

public class LC_0077_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, 1, n, k, new ArrayList<>());
        return res;
    }

    public void dfs(List<List<Integer>> res, int start, int n,  int k, List<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (start > n) return;

        // choose current number
        path.add(start);
        dfs(res, start+1, n, k, path);
        // not choose current number
        path.removeLast();
        dfs(res, start+1, n, k, path);
    }
}
